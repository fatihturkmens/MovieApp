package com.movieapp.movieapp.service;



import com.movieapp.movieapp.domain.Movie;
import com.movieapp.movieapp.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> getAllMovies() {                   /// get all movie
        return movieRepository.findAll();
    }   // get all movies
     public String createMovie(Movie movie){        // create new movie
        movieRepository.save(movie);
        return "movie added";
     }
         public Movie getaMovie(Long id){
        Optional<Movie> movie= movieRepository.findById(id);    /// get movie
        return movie.get();
         }

         public String deleteMovie(Long id){           /// delete movie
         movieRepository.deleteById(id);
         return "Movie is deleted";
         }


        public String updatemovie(Movie movie){             /// update movie
        movieRepository.findById(movie.getId()).orElseThrow();
        movieRepository.save(movie);
        return "movie is updated";
        }

}
