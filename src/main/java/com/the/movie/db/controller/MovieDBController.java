package com.the.movie.db.controller;

import com.the.movie.db.dto.MovieDTO;
import com.the.movie.db.dto.ResultMovieDTO;
import com.the.movie.db.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@Controller
public class MovieDBController {

    @Autowired
    private MovieService service;

    @GetMapping
    public String getAllMovies(Model model){

        MovieDTO response = this.service.getAll(String.format(MovieService.url.concat("1"),"movie"));
        model.addAttribute("results",response.getResults());
        model.addAttribute("prev",null);
        model.addAttribute("next", String.valueOf(response.getPage() + 1));
        model.addAttribute("page",response.getPage() );

        return "index";
    }
    @GetMapping(value="/pageable" )
    public String getPageable(Model model, @RequestParam(required = false) String antes,@RequestParam(required = false) String despues,
                              HttpServletRequest request,
                              @RequestParam(defaultValue = "movie") String type){
        String page = request.getParameter("page");
        System.out.println("PAGE PARAMETER {} " +page);
        String search = null;
        String prev = null;
        String next = null;
        if(Objects.nonNull(antes) && antes.equalsIgnoreCase("1")){
            search = Integer.parseInt(page)<=1 ? null : String.valueOf(Integer.parseInt(page) - 1);
            prev = Integer.parseInt(page)<=2 ? null : String.valueOf(Integer.parseInt(page) - 1);
            next =String.valueOf(Integer.parseInt(page) + 1);

            System.out.println("PARANETER1 PREV : {}" + prev);
            System.out.println("PARANETER1 NEXT : {}" + next);
            System.out.println("PARANETER1 SEARCH : {}" + search);
        }else if(Objects.nonNull(despues) && despues.equalsIgnoreCase("2")){
            search = String.valueOf(Integer.parseInt(page) + 1);
            prev = Integer.parseInt(page)<=2 ? null : String.valueOf(Integer.parseInt(page) - 1);;
            next = search;

            System.out.println("PARANETER2 PREV : {}" + prev);
            System.out.println("PARANETER2 NEXT : {}" + next);
            System.out.println("PARANETER2 SEARCH : {}" + search);
        }
        if(Objects.nonNull(search)){
            MovieDTO response = this.service.getAll(String.format(MovieService.url.concat(search),type));
            model.addAttribute("prev",prev);
            model.addAttribute("next",next);
            model.addAttribute("page",response.getPage());
            model.addAttribute("results",response.getResults());
        }

        return "index";
    }

    @GetMapping("/search")
    public String getById(Model model,@RequestParam String id){
        ResultMovieDTO response = this.service.getById(Integer.parseInt(id));
        model.addAttribute("title",response.getOriginal_title() + ": " + response.getId());
        model.addAttribute("result",response);
        System.out.println(response.toString());
        return "movie";
    }
}
