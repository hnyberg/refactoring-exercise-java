package com.greatersum.rental.services;

import com.greatersum.rental.model.Customer;
import com.greatersum.rental.model.Movie;
import com.greatersum.rental.model.MovieRental;
import com.greatersum.rental.model.MovieRepository;

import java.math.BigDecimal;
import java.util.HashMap;

public class StatementService {

    public static String getStatementForCustomer(Customer customer) {

        HashMap<String, Movie> movies = MovieRepository.getMovies();
        BigDecimal totalAmount = BigDecimal.valueOf(0);
        int frequentRenterPoints = 0;
        String result = "Rental Record for " + customer.getName() + "\n";
        for (MovieRental r : customer.getRentals()) {
            Movie movie = movies.get(r.getMovieId());
            BigDecimal thisAmount = BigDecimal.valueOf(0);

            // determine amount for each movie
            switch (movie.getCategory()) {
                case REGULAR:
                    thisAmount = BigDecimal.valueOf(2);
                    if (r.getDays() > 2) {
                        thisAmount = thisAmount.add(BigDecimal.valueOf((r.getDays() - 2) * 1.5));
                    }
                    break;
                case NEW:
                    thisAmount = BigDecimal.valueOf(r.getDays() * 3);
                    break;
                case CHILDRENS:
                    thisAmount = BigDecimal.valueOf(1.5);
                    if (r.getDays() > 3) {
                        thisAmount = BigDecimal.valueOf((r.getDays() - 3) * 1.5).add(thisAmount);
                    }
                    break;
            }

            //add frequent renter points
            frequentRenterPoints++;
            // add bonus for a two day new release rental
            if (movie.getCategory() == Movie.Category.NEW && r.getDays() > 2) frequentRenterPoints++;

            //print figures for this rental
            result += "\t" + movie.getTitle() + "\t" + thisAmount + "\n";
            totalAmount = totalAmount.add(thisAmount);
        }
        // add footer lines
        result += "Amount owed is " + totalAmount + "\n";
        result += "You earned " + frequentRenterPoints + " frequent renter points\n";

        return result;
    }
}
