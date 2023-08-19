package com.the.movie.db.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieDTO {
    private Integer page;

    private ResultMovieDTO[] results;

    @Override
    public String toString() {
        return "MovieDTO{" +
                "page=" + page +
                ", results=" + Arrays.toString(results) +
                '}';
    }
}
