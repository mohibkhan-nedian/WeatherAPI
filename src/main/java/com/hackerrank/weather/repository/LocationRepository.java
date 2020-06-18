package com.hackerrank.weather.repository;

import com.hackerrank.weather.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("locationRepository")
public interface LocationRepository extends JpaRepository<Location, Long> {
}
