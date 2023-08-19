package com.the.movie.db.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Component
public class ConsumeApi<T>{

    @Autowired
    private RestTemplate restTemplate;

     public T getApi(String url,Class<T> type){
         HttpHeaders headers = new HttpHeaders();
         headers.setContentType(MediaType.APPLICATION_JSON);
         headers.set("Authorization","Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJhNGI3ZDhiMGZlZGUwYzZlZDA0NzE0N2MwMGU3NTQ1YiIsInN1YiI6IjVmZjYzODNlMWQ2YzVmMDAzZjRmOTQzYiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.JqEmxMmbhRO5jS6wiQEhUVvXcjvtxjulYAtnmYxk-18");
         HttpEntity<String> entity = new HttpEntity<>("parameters",headers);
         return this.restTemplate.exchange(url,HttpMethod.GET,entity,type).getBody();
    }
}
