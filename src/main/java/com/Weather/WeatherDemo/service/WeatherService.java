package com.Weather.WeatherDemo.service;

import org.springframework.stereotype.Component;

@Component
public interface WeatherService {
    String getWeatherSummary(String city);

    String getWeatherHourly(String city);
}
