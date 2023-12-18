package com.PSP.lr7_pt2.controllers.Tasks;

import com.PSP.lr7_pt2.models.Movie;
import com.PSP.lr7_pt2.models.Person;
import com.PSP.lr7_pt2.repository.MovieRepository;
import com.PSP.lr7_pt2.service.MovieVisual;
import com.PSP.lr7_pt2.service.ShowAllMoves;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class Task1 {
    @Autowired
    MovieRepository movieRepository;

    @GetMapping("/task1")
    public String task1(Model model) {

        LocalDate currentDate = LocalDate.now();
        LocalDate lastYearDate = currentDate.minusYears(1);

        List<Movie> movies = movieRepository.findByReleaseDateBetween(lastYearDate, currentDate);


        ShowAllMoves showAllMoves = new ShowAllMoves(movieRepository);
        List<MovieVisual> movieVisualList = new ArrayList<>(showAllMoves.showCurrentMovies(movies));
        model.addAttribute("movies", movieVisualList);

        return "task1";
    }
}
