package com.the.movie.db.controller;

import com.the.movie.db.dto.MovieDTO;
import com.the.movie.db.dto.ResultMovieDTO;
import com.the.movie.db.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MovieDBController {

    @Autowired
    private MovieService service;

    @GetMapping
    public String getAllMovies(Model model){
        String prev = null ;
        String next = String.valueOf(Integer.parseInt("1") + 1);
        MovieDTO response = this.service.getAll(String.format(MovieService.url.concat("1"),"movie"));
        model.addAttribute("results",response.getResults());
        model.addAttribute("prev",prev);
        model.addAttribute("next",next);
        System.out.println("prev getAllMovies " + prev);
        System.out.println("next  getAllMovies " + next);
        return "index";
    }
    @GetMapping(value="/pageable" ,params = {"antes","despues","type"})
    public String getPageable(Model model, @RequestParam(defaultValue = "1") String antes,@RequestParam(defaultValue = "2",required = false) String despues, @RequestParam(defaultValue = "movie") String type){
        String prev = antes.equalsIgnoreCase("1") ? "null" : String.valueOf((Integer.parseInt(despues)-1)) ;
        String next = String.valueOf(Integer.parseInt(despues) + 1);
        System.out.println("prev getPageable" + antes);
        System.out.println("next  getPageable" + despues);
        MovieDTO response = this.service.getAll(String.format(MovieService.url.concat(prev),type));
        model.addAttribute("prev",prev);
        model.addAttribute("next",next);
        model.addAttribute("results",response.getResults());
        return "index";
    }
}
