package com.greatersum.rental.model;

import java.util.HashMap;

import static com.greatersum.rental.model.Movie.*;

public class MovieRepository {

    public static HashMap<String, Movie> getMovies(){
        HashMap<String, Movie> movies = new HashMap<>();
        movies.put("F001", new Movie("Ran", Category.REGULAR));
        movies.put("F002", new Movie("Trois Couleurs: Bleu", Category.REGULAR));
        movies.put("F003", new Movie("Cars 2", Category.CHILDRENS));
        movies.put("F004", new Movie("Latest Hit Release", Category.NEW));
        return movies;
    }
}
