package com.PSP.lr7_pt2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainPageController {
    @GetMapping("/")
    public String mainPage(Model model) {
        System.out.println("Мы на главной странице!");
        return "index";
    }
}
