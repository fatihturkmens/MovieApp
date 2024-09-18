package com.movieapp.movieapp.controller;

import com.movieapp.movieapp.domain.Movie;
import com.movieapp.movieapp.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("movies")
public class Moviescontroller {

    @Autowired
    private MovieService movieService;
    // get all films
    @GetMapping("/allmovies")//
    public ResponseEntity<List<Movie>> listallmovies(){
        List<Movie> movies=movieService.getAllMovies();
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }


       @PostMapping("newmovie")                                                     // create a new movie
      public ResponseEntity<String>createMovie(@RequestBody Movie movie){
        movieService.createMovie(movie);
        return new ResponseEntity<>("movie added",HttpStatus.CREATED);
       }

         @GetMapping("movie/{id}")      //get a movie
     public ResponseEntity<Movie>getaMovie(@PathVariable Long id){
        Movie movie=movieService.getaMovie(id);
        return new ResponseEntity<>(movie,HttpStatus.OK);

         }

        @DeleteMapping("/delete/{id}")// delete Movie
     public ResponseEntity<String>deleteMovie(@PathVariable Long id){
        movieService.deleteMovie(id);
        return new ResponseEntity<>("movie deleted",HttpStatus.OK);
        }


        @PutMapping("/update")// update movie
     public ResponseEntity<String>updateMovie(@RequestBody Movie movie){
        movieService.updatemovie(movie);
        return new ResponseEntity<>("Movie is updated",HttpStatus.OK);
        }
}
