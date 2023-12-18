package com.PSP.lr7_pt2.controllers.Tasks;

import com.PSP.lr7_pt2.models.Movie;
import com.PSP.lr7_pt2.repository.MovieRepository;
import com.PSP.lr7_pt2.service.MovieJSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class Task2_1Rest {

    @Autowired
    MovieRepository movieRepository;

    @PostMapping("/check_movie/{id}")
    public boolean checkMovieID(@PathVariable Long id) {
        Optional<Movie> optionalMovie = movieRepository.findById(id);

        if (optionalMovie.isPresent()) {
            return true;
        } else {
            return false;
        }
    }
}