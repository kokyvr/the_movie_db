package com.the.movie.db.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieDTO {
    private Integer page;

    private ResultMovieDTO[] results;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public ResultMovieDTO[] getResults() {
        return results;
    }

    public void setResults(ResultMovieDTO[] results) {
        this.results = results;
    }
}
