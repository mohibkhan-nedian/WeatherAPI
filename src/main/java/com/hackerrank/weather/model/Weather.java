package com.hackerrank.weather.model;

import javax.persistence.CascadeType;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "weather")
public class Weather implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date dateRecorded;

    @OneToOne(cascade =  CascadeType.ALL, mappedBy = "weather")
    private Location location;

    private Float temperature;

    public Weather() {
    }

    public Weather(final Date dateRecorded, final Location location, final Float temperature) {
        this.dateRecorded = dateRecorded;
        this.location = location;
        this.temperature = temperature;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public Date getDateRecorded() {
        return dateRecorded;
    }

    public void setDateRecorded(final Date dateRecorded) {
        this.dateRecorded = dateRecorded;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(final Location location) {
        this.location = location;
    }

    public Float getTemperature() {
        return temperature;
    }

    public void setTemperature(final Float temperature) {
        this.temperature = temperature;
    }

}
