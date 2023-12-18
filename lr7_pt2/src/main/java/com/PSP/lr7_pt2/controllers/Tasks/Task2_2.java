package com.PSP.lr7_pt2.controllers.Tasks;

import com.PSP.lr7_pt2.models.Movie;
import com.PSP.lr7_pt2.models.Person;
import com.PSP.lr7_pt2.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Set;

@Controller
public class Task2_2 {
    @Autowired
    MovieRepository movieRepository;

    @GetMapping("/task2/{id}")
    public String task1(Model model, @PathVariable Long id) {

        Movie movie = movieRepository.findById(id).orElse(null);

        if (movie != null) {
            Set<Person> actors = movie.getActors();
            // Вывод информации об актерах
            for (Person actor : actors) {
                System.out.println("Имя актера: " + actor.getName());
                System.out.println("Дата рождения актера: " + actor.getDateOfBirth());
            }

            model.addAttribute("actors", actors);
        }
        return "task2_2";
    }
}
