package com.greatersum.rental;

import java.math.BigDecimal;
import java.util.HashMap;

import static com.greatersum.rental.Movie.*;

public class MovieRepository {

    public String getStatementForCustomer(Customer customer) {
        HashMap<String, Movie> movies = new HashMap();
        movies.put("F001", new Movie("Ran", Category.REGULAR));
        movies.put("F002", new Movie("Trois Couleurs: Bleu", Category.REGULAR));
        movies.put("F003", new Movie("Cars 2", Category.CHILDRENS));
        movies.put("F004", new Movie("Latest Hit Release", Category.NEW));

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
            if (movie.getCategory() == Category.NEW && r.getDays() > 2) frequentRenterPoints++;

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
