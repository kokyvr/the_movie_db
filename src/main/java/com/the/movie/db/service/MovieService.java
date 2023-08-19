package com.the.movie.db.service;

import com.the.movie.db.dto.MovieDTO;

public interface MovieService {

    public static String url = "https://api.themoviedb.org/3/discover/movie?include_adult=false&include_video=false&language=es-ES&sort_by=popularity.asc&page=";
    public MovieDTO getAll(String url);


}
