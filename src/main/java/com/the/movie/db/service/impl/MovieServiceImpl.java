package com.the.movie.db.service.impl;

import com.the.movie.db.dto.MovieDTO;
import com.the.movie.db.dto.ResultMovieDTO;
import com.the.movie.db.service.MovieService;
import com.the.movie.db.utils.ConsumeApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private ConsumeApi<MovieDTO> restTemplate;

    @Autowired
    private ConsumeApi<ResultMovieDTO> movieRestTemplate;
    @Override
    public MovieDTO getAll(String url) {
        return this.restTemplate.getApi(url,MovieDTO.class);
    }

    @Override
    public ResultMovieDTO getById(Integer id) {
        return this.movieRestTemplate.getApi(String.format(urlByIdMovie,id),ResultMovieDTO.class);
    }
}
