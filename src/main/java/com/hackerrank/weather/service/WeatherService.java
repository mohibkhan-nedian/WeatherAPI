package com.hackerrank.weather.service;

import com.hackerrank.weather.exception.BadResourceRequestException;
import com.hackerrank.weather.model.Weather;

import java.util.Date;
import java.util.List;

public interface WeatherService {

    void deleteAllWeathers();

    void createWeather(Weather weather) throws BadResourceRequestException;

    List<Weather> getAllWeathers();

    List<Weather> getFilteredWeatherForLocation(final Float lat, final Float lon) throws BadResourceRequestException;

    void deleteByDataRangeAndLocation(Date startDate, Date endDate, Float lat, Float lon);
}
