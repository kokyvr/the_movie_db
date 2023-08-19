package com.the.movie.db.controller;

import com.the.movie.db.dto.MovieDTO;
import com.the.movie.db.dto.ResultMovieDTO;
import com.the.movie.db.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MovieDBController {

    @Autowired
    private MovieService service;

    @GetMapping
    public String getAllMovies(Model model){
        MovieDTO response = this.service.getAll(MovieService.url.concat("1"));
        model.addAttribute("results",response.getResults());
        for (ResultMovieDTO result: response.getResults()){
            System.out.println(result.getBackdrop_path());
        }
        return "index";
    }
}
