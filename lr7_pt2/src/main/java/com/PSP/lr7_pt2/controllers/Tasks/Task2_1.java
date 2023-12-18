package com.PSP.lr7_pt2.controllers.Tasks;

import com.PSP.lr7_pt2.models.Movie;
import com.PSP.lr7_pt2.service.MovieVisual;
import com.PSP.lr7_pt2.service.ShowAllMoves;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class Task2_1 {
    @GetMapping("/task2")
    public String task2(Model model) {




        return "task2_1";
    }
}
