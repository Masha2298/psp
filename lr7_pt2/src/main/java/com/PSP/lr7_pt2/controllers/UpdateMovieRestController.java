package com.PSP.lr7_pt2.controllers;

import com.PSP.lr7_pt2.models.Movie;
import com.PSP.lr7_pt2.models.Person;
import com.PSP.lr7_pt2.repository.MovieRepository;
import com.PSP.lr7_pt2.repository.PersonRepository;
import com.PSP.lr7_pt2.service.MovieJSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
public class UpdateMovieRestController {
    @Autowired
    MovieRepository movieRepository;

    @Autowired
    PersonRepository personRepository;

    @PostMapping("/update_movie/{id}")
    public boolean updateMovie(@RequestBody MovieJSON movieJSON, @PathVariable Long id) {

        Optional<Movie> optionalMovie = movieRepository.findById(id);

        if (optionalMovie.isPresent()) {
            Movie movie = optionalMovie.get();

            movie.setName(movieJSON.getName());
            movie.setCountry(movieJSON.getCountry());
            movie.setReleaseDate(movieJSON.getDate());

            List<String> stringDirectors = movieJSON.getDirectors();
            Set<Person> directors = new HashSet<>();
            for (int i = 0; i < stringDirectors.size(); i++) {
                Person director = personRepository.findByName(stringDirectors.get(i));
                directors.add(director);
            }

            List<String> stringActors = movieJSON.getActors();
            Set<Person> actors = new HashSet<>();
            for (int i = 0; i < stringActors.size(); i++) {
                Person actor = personRepository.findByName(stringActors.get(i));
                actors.add(actor);
            }

            movie.setDirectors(directors);
            movie.setActors(actors);

            movieRepository.save(movie);

            return true;
        } else {
            return false;
        }
    }
}

