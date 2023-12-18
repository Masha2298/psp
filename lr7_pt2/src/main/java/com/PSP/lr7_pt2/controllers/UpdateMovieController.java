package com.PSP.lr7_pt2.controllers;

import com.PSP.lr7_pt2.models.Movie;
import com.PSP.lr7_pt2.models.Person;
import com.PSP.lr7_pt2.repository.MovieRepository;
import com.PSP.lr7_pt2.repository.PersonRepository;
import com.PSP.lr7_pt2.service.MovieVisual;
import com.PSP.lr7_pt2.service.ShowAllMoves;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
public class UpdateMovieController {
    @Autowired
    MovieRepository movieRepository;

    @Autowired
    PersonRepository personRepository;

    @GetMapping("/updateMovie")
    public String updateMovie(Model model) {

        ShowAllMoves showAllMoves = new ShowAllMoves(movieRepository);
        List<MovieVisual> movieVisualList = new ArrayList<>(showAllMoves.showAllMovies());
        model.addAttribute("movies", movieVisualList);

        List<Person> personList = new ArrayList<>(personRepository.findAll());
        model.addAttribute("persons", personList);

        return "updateMovie";
    }
}
