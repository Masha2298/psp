package com.PSP.lr7_pt2.controllers;

import com.PSP.lr7_pt2.models.Movie;
import com.PSP.lr7_pt2.models.Person;
import com.PSP.lr7_pt2.repository.MovieRepository;
import com.PSP.lr7_pt2.service.MovieJSON;
import com.PSP.lr7_pt2.service.MovieVisual;
import com.PSP.lr7_pt2.service.ShowAllMoves;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class ShowMoviesController {

    @Autowired
    MovieRepository movieRepository;

    @GetMapping("/showMovies")
    public String showMovies(Model model) {

        ShowAllMoves showAllMoves = new ShowAllMoves(movieRepository);
        List<MovieVisual> movieVisualList = new ArrayList<>(showAllMoves.showAllMovies());
        model.addAttribute("movies", movieVisualList);

        return "showMovies";
    }
}
