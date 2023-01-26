package com.driver;

import org.springframework.stereotype.Repository;

import java.util.HashSet;

@Repository
public class MovieRepository {
    HashSet<Movie>movies = new HashSet<>();

    public String addMovie(Movie movie){
        movies.add(movie);
        return "Movie added Successfully";
    }

    public Movie getMovieByName(String name){
        for(Movie movie : movies){
            if(name.equals(movie.getName())){
                return movie;
            }
        }
        return null;
    }
}
