package com.hackerrank.weather.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "location")
public class Location implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long weatherId;

    @OneToOne
    @JoinColumn(name = "weather_id", nullable = false)
    Weather weather;

    private String cityName;

    private String stateName;

    private Float latitude;

    private Float longitude;

    public Location() {
    }

    public Location(final String cityName, final String stateName, final Float latitude, final Float longitude) {
        this.cityName = cityName;
        this.stateName = stateName;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Long getWeatherId() {
        return weatherId;
    }

    public void setWeatherId(final Long weatherId) {
        this.weatherId = weatherId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(final String cityName) {
        this.cityName = cityName;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(final String stateName) {
        this.stateName = stateName;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(final Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(final Float longitude) {
        this.longitude = longitude;
    }

}
