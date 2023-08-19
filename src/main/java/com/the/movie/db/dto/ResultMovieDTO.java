package com.the.movie.db.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultMovieDTO {

    private String id;
    private Boolean adult;

    private String backdrop_path;

    private String original_title;

    private String[] ids;

}
