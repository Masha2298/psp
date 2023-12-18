package com.PSP.lr7_pt2.controllers;

//import com.PSP.lr7_pt2.models.Person;
//import com.PSP.lr7_pt2.repository.PersonRepository;
import com.PSP.lr7_pt2.models.Person;
import com.PSP.lr7_pt2.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class AddMovieController {

    @Autowired
    private PersonRepository personRepository;


    @GetMapping("/addMovie")
    public String addMovie(Model model) {

        List<Person> personList = new ArrayList<>(personRepository.findAll());
        model.addAttribute("persons", personList);

        return "addMovie";
    }
}

