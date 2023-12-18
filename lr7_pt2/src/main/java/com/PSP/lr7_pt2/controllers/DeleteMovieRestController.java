package com.PSP.lr7_pt2.controllers;

import com.PSP.lr7_pt2.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteMovieRestController {

    @Autowired
    MovieRepository movieRepository;

    @DeleteMapping("delete_movie/{id}")
    public boolean deletePerson(@PathVariable Long id) {

        movieRepository.deleteById(id);

        return true;
    }

}
