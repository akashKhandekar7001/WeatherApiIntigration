package com.Weather.WeatherDemo.controller;

import com.Weather.WeatherDemo.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    WeatherService weatherService;

    //API 1: Get the Weather forecast summary of Any city using API
    @GetMapping("/{city}")
    public String getWeatherForecastSummaryByCity(@PathVariable String city){
        return weatherService.getWeatherSummary(city);
    }

    //    API 2: Get hourly Weather forecast details of Any city using API
    @GetMapping("/hourly/{city}")
    public String getWeatherForecastByCityHourly(@PathVariable String city){
        return weatherService.getWeatherHourly(city);
    }
}
