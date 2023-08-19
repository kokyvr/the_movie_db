package com.the.movie.db.service;

import com.the.movie.db.dto.MovieDTO;
import com.the.movie.db.dto.SingleMovieDTO;

public interface MovieService {

    public static String url = "https://api.themoviedb.org/3/discover/%s?include_adult=false&include_video=false&language=es-ES&sort_by=popularity.desc&page=";
   public static String urlByIdMovie = "https://api.themoviedb.org/3/movie/%s?language=es-ES";
    public MovieDTO getAll(String url);

    public SingleMovieDTO getById(Integer id);


}
