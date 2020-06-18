package com.hackerrank.weather.service;

import com.hackerrank.weather.exception.BadResourceRequestException;
import com.hackerrank.weather.model.Weather;
import com.hackerrank.weather.repository.WeatherRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("weatherService")
public class WeatherServiceImpl implements WeatherService {

    private final WeatherRepository weatherRepository;

    public WeatherServiceImpl(final WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }

    @Override
    public void deleteAllWeathers() {
        weatherRepository.deleteAll();
    }

    @Override
    public void createWeather(final Weather weather) throws BadResourceRequestException {
        Weather existingWeather = weatherRepository.findOne(weather.getId());

        if (existingWeather != null) {
            throw new BadResourceRequestException("Weather with same id exists.");
        }
        weatherRepository.save(weather);
    }

    @Override
    public List<Weather> getAllWeathers() {
        return weatherRepository.findAllByOrderByIdAsc();
    }

    @Override
    public List<Weather> getFilteredWeatherForLocation(final Float lat, final Float lon) throws BadResourceRequestException {
        List<Weather> weatherList = weatherRepository.findByLocationLatitudeAndLocationLongitude(lat, lon);

        if(weatherList.size() == 0) {
            throw new BadResourceRequestException("Request params do not match records.");
        }
        return weatherList;
    }

    @Override
    public void deleteByDataRangeAndLocation(final Date startDate, final Date endDate, final Float lat, final Float lon) {
        weatherRepository.deleteByDateRecordedBetweenAndLocationLatitudeAndLocationLongitude(startDate, endDate, lat, lon);
    }
}
