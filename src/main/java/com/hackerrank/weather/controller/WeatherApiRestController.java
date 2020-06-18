package com.hackerrank.weather.controller;

import com.hackerrank.weather.exception.BadResourceRequestException;
import com.hackerrank.weather.model.Weather;
import com.hackerrank.weather.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
public class WeatherApiRestController {

    private final WeatherService weatherService;

    @Autowired
    public WeatherApiRestController(final WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @RequestMapping(value = "/weather", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void createNewWeather(final @RequestBody @Valid Weather weather) throws BadResourceRequestException {
        weatherService.createWeather(weather);
    }

    @RequestMapping(value = "/weather", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Weather> getAllWeathers() {
        return weatherService.getAllWeathers();
    }

    @RequestMapping(value = "/weather", params = {"lat", "lon"}, method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Weather> getFilteredWeatherForLocation(final @RequestParam Float lat, final @RequestParam Float lon)
            throws BadResourceRequestException {
        return weatherService.getFilteredWeatherForLocation(lat, lon);
    }

    @RequestMapping(value = "/erase", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteAllWeathers() {
        weatherService.deleteAllWeathers();
    }

    @RequestMapping(value = "/erase", params = {"start", "end", "lat", "lon"}, method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteByDataRangeAndLocation(final @RequestParam("start") @DateTimeFormat(pattern="yyyy-MM-dd") Date startDate,
                                             final @RequestParam("end") @DateTimeFormat(pattern="yyyy-MM-dd") Date endDate,
                                             final @RequestParam Float lat,
                                             final @RequestParam Float lon) {
        weatherService.deleteByDataRangeAndLocation(startDate, endDate, lat, lon);
    }

    @RequestMapping(value = "/weather/temperature", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public void getTemperaturesForDateRange(final @RequestParam("start") @DateTimeFormat(pattern="yyyy-MM-dd") Date startDate,
                                            final @RequestParam("end") @DateTimeFormat(pattern="yyyy-MM-dd") Date endDate) {

    }
}
