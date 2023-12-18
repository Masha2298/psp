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
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
public class Task5_2 {
    @Autowired
    MovieRepository movieRepository;

    @GetMapping("/task5/{n}")
    public String task5(Model model, @PathVariable Long n) {

        int yearsAgo = Math.toIntExact(n);
        LocalDate thresholdDate = LocalDate.now().minusYears(yearsAgo);
        List<Movie> moviesToDelete = movieRepository.findByReleaseDateBefore(thresholdDate);

        ShowAllMoves showAllMoves = new ShowAllMoves(movieRepository);
        List<MovieVisual> movieVisualList = new ArrayList<>(showAllMoves.showCurrentMovies(moviesToDelete));
        model.addAttribute("movies", movieVisualList);


        movieRepository.deleteAll(moviesToDelete);

        return "task5_2";
    }
}