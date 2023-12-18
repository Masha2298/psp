package com.PSP.lr7_pt2.controllers.Tasks;

import com.PSP.lr7_pt2.models.Person;
import com.PSP.lr7_pt2.repository.MovieRepository;
import com.PSP.lr7_pt2.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class Task5_1 {
    @Autowired
    MovieRepository movieRepository;

    @Autowired
    PersonRepository personRepository;

    @GetMapping("/task5")
    public String task5(Model model) {
        return "task5_1";
    }
}