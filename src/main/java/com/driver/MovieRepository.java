package com.driver;

import org.apache.catalina.LifecycleState;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MovieRepository {
    Map<String,Movie> movies = new HashMap<>();
    Map<String, Director>directors = new HashMap<>();
    Map<String, List<String>>movieDirector = new HashMap<>();

    public String addMovie(Movie movie){
        movies.put(movie.getName(),movie);
        return "Movie added Successfully";
    }

    public String addDirector(Director director){
        directors.put(director.getName(),director);
        return "Director added Successfully";
    }

    public void addMovieDirectorPair(String movieName, String directorName){
        if(movies.containsKey(movieName) && directors.containsKey(directorName)){
            List<String> list = new ArrayList<>();
            if(movieDirector.containsKey(directorName))
                list = movieDirector.get(directorName);
            list.add(movieName);
            movieDirector.put(directorName, list);
        }
    }


    public Movie getMovieByName(String name){
        if(!movies.containsKey(name))
            return null;
        return movies.get(name);
    }

    public Director getDirectorByName(String name){
        if(!directors.containsKey(name))
            return null;
        return directors.get(name);
    }

    public List<String> getMoviesByDirectorName(String director){
        if(!movieDirector.containsKey(director))
            return null;
        return movieDirector.get(director);
    }

    public List<String> findAllMovies(){
        return new ArrayList<>(movies.keySet());
    }
}
