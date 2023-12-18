package com.PSP.lr7_pt2.controllers.Tasks;

import com.PSP.lr7_pt2.models.Movie;
import com.PSP.lr7_pt2.models.Person;
import com.PSP.lr7_pt2.repository.MovieRepository;
import com.PSP.lr7_pt2.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Set;

@Controller
public class Task4 {
    @Autowired
    MovieRepository movieRepository;

    @Autowired
    PersonRepository personRepository;

    @GetMapping("/task4")
    public String task4(Model model) {

        List<Person> actorDirectors = personRepository.findByActedFilmsIsNotEmptyAndDirectedFilmsIsNotEmpty();

        // Вывод информации об актерах-режиссерах
        for (Person actorDirector : actorDirectors) {
            System.out.println("Имя актера-режиссера: " + actorDirector.getName());
            System.out.println("Дата рождения актера-режиссера: " + actorDirector.getDateOfBirth());
        }

        model.addAttribute("actors", actorDirectors);

        return "task4";
    }
}