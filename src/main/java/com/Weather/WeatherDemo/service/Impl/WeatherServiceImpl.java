package com.Weather.WeatherDemo.service.Impl;

import com.Weather.WeatherDemo.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@Service
public class WeatherServiceImpl implements WeatherService {

    private static final String API_BASE_URL = "https://forecast9.p.rapidapi.com/rapidapi/forecast/";

    private static final String API_BASE_URL_Hourly = "https://forecast9.p.rapidapi.com/rapidapi/forecast/Berlin/hourly/";
    @Autowired
    RestTemplate restTemplate;
    @Value("${rapidapi.key}")
    private String rapidApiKey;

    public String getWeatherSummary(String city){
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-RapidAPI-Key", rapidApiKey);
        headers.set("X-RapidAPI-Host", "forecast9.p.rapidapi.com");
        String apiUrl = API_BASE_URL + city +"/summary";
        RequestEntity<Void> requestEntity = new RequestEntity<>(headers, HttpMethod.GET, URI.create(apiUrl));
        return restTemplate.exchange(requestEntity, String.class).getBody();
    }


    public String getWeatherHourly(String city){
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-RapidAPI-Key", rapidApiKey);
        headers.set("X-RapidAPI-Host", "forecast9.p.rapidapi.com");
        String apiUrl = API_BASE_URL_Hourly + city +"/summary";
        RequestEntity<Void> requestEntity = new RequestEntity<>(headers, HttpMethod.GET, URI.create(apiUrl));
        return restTemplate.exchange(requestEntity, String.class).getBody();
    }
}
