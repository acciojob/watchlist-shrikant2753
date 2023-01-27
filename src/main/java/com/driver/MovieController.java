package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {
    @Autowired
    MovieService movieService;

    @PostMapping("/add-movie")
    public ResponseEntity addMovie(@RequestBody Movie movie){
        String response = movieService.addMovie(movie);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/add-director")
    public ResponseEntity addDirector(@RequestBody Director director){
        String response = movieService.addDirector(director);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/add-movie-director-pair")
    public ResponseEntity addMovieDirectorPair(@RequestParam("movie") String movie, @RequestParam("director") String director){
        movieService.addMovieDirectorPair(movie, director);
        return new ResponseEntity("Movie director pair added successfully", HttpStatus.CREATED);
    }

    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity getMovieByName(@PathVariable("name") String name){
        Movie response = movieService.getMovieByName(name);
        if(response==null)
            return new ResponseEntity<>("Invalid name", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(response, HttpStatus.FOUND);
    }

    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity getDirectorByName(@PathVariable("name") String name){
        Director response = movieService.getDirectorByName(name);
        if(response==null)
            return new ResponseEntity<>("Invalid Director name", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(response, HttpStatus.FOUND);
    }

    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity getMoviesByDirectorName(@PathVariable("director") String director){
        List<String> response = movieService.getMoviesByDirectorName(director);
        if(response==null)
            return new ResponseEntity<>("Invalid director name", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(response, HttpStatus.FOUND);
    }

    @GetMapping("/get-all-movies")
    public ResponseEntity findAllMovies(){
        List<String>response = movieService.findAllMovies();
        if(response==null)
            return new ResponseEntity<>("No movie in the database", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(response, HttpStatus.FOUND);
    }
}
