package com.hackerrank.weather.repository;

import com.hackerrank.weather.model.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Repository
public interface WeatherRepository extends JpaRepository<Weather, Long> {
    @Transactional
    List<Weather> findAllByOrderByIdAsc();

    @Transactional
    List<Weather> findByLocationLatitudeAndLocationLongitude(Float lat, Float lon);

    @Transactional
    void deleteByDateRecordedBetweenAndLocationLatitudeAndLocationLongitude(Date startDate, Date endDate, Float lat, Float lon);
}
