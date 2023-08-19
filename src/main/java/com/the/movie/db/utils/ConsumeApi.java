package com.the.movie.db.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class ConsumeApi<T>{

    @Autowired
    private RestTemplate restTemplate;

     public T getApi(String url,Class<T> type){
         return this.restTemplate.getForEntity(url,type).getBody();
    }
}
