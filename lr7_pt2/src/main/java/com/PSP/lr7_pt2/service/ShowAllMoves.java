package com.PSP.lr7_pt2.service;

import com.PSP.lr7_pt2.models.Movie;
import com.PSP.lr7_pt2.models.Person;
import com.PSP.lr7_pt2.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ShowAllMoves {
    private MovieRepository movieRepository;

    @Autowired
    public ShowAllMoves(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<MovieVisual> showAllMovies() {
        List<Movie> repositoryMovies = new ArrayList<>(movieRepository.findAll());

        List<MovieVisual> movieVisualList = new ArrayList<>();

        for (int i = 0; i < repositoryMovies.size(); i++) {
            MovieVisual currentMovie = new MovieVisual();

            currentMovie.setId(Math.toIntExact(repositoryMovies.get(i).getID()));
            currentMovie.setName(repositoryMovies.get(i).getName());
            currentMovie.setCountry(repositoryMovies.get(i).getCountry());
            currentMovie.setDate(repositoryMovies.get(i).getReleaseDate());

            StringBuilder directors = new StringBuilder();
            Set<Person> setDirectors = repositoryMovies.get(i).getDirectors();

            for (Person director : setDirectors) {
                directors.append(director.getName());
            }

            currentMovie.setDirectors(directors.toString());

            StringBuilder actors = new StringBuilder();
            Set<Person> setActors = repositoryMovies.get(i).getActors();

            for (Person actor : setActors) {
                actors.append(actor.getName());
            }

            currentMovie.setActors(actors.toString());

            movieVisualList.add(currentMovie);
        }

        return movieVisualList;
    }

    public List<MovieVisual> showCurrentMovies(List<Movie> repositoryMovies) {

        List<MovieVisual> movieVisualList = new ArrayList<>();

        for (int i = 0; i < repositoryMovies.size(); i++) {
            MovieVisual currentMovie = new MovieVisual();

            currentMovie.setId(Math.toIntExact(repositoryMovies.get(i).getID()));
            currentMovie.setName(repositoryMovies.get(i).getName());
            currentMovie.setCountry(repositoryMovies.get(i).getCountry());
            currentMovie.setDate(repositoryMovies.get(i).getReleaseDate());

            StringBuilder directors = new StringBuilder();
            Set<Person> setDirectors = repositoryMovies.get(i).getDirectors();

            for (Person director : setDirectors) {
                directors.append(director.getName());
            }

            currentMovie.setDirectors(directors.toString());

            StringBuilder actors = new StringBuilder();
            Set<Person> setActors = repositoryMovies.get(i).getActors();

            for (Person actor : setActors) {
                actors.append(actor.getName());
            }

            currentMovie.setActors(actors.toString());

            movieVisualList.add(currentMovie);
        }

        return movieVisualList;
    }
}
