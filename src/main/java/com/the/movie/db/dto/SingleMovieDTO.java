package com.the.movie.db.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SingleMovieDTO {
    private Boolean adult;
    private String backdrop_path;
    private Object belongs_to_collection;
    private Long budget;
    private List<Genre> genres;
    private String homepage;
    private Long id;
    private String imdb_id;
    private String original_language;
    private String original_title;
    private String overview;
    private Double popularity;
    private String poster_path;


    private Long revenue;
    private Long runtime;

    private String status;
    private String tagline;
    private String title;
    private Boolean video;
    private Double vote_average;
    private Long vote_count;
}
