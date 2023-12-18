package com.PSP.lr7_pt2.controllers.Tasks;

import com.PSP.lr7_pt2.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Task3_1 {
    @Autowired
    MovieRepository movieRepository;

    @GetMapping("/task3")
    public String task3(Model model) {
        return "task3_1";
    }
}
