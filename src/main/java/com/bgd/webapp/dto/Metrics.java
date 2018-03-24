package com.bgd.webapp.dto;

import com.bgd.webapp.dto.indexes.Humidex;
import com.bgd.webapp.dto.indexes.ThermoHumidityIndex;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Transient;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Metrics implements Serializable {
    @Id
    protected String id;
    @Column(name = "mdate")
    protected LocalDateTime date;
    protected double airTemperature;
    protected double relevantHumidity;
    protected double windDirection;
    protected double windSpeed;
    protected double radiation;
    protected double sphereTemperature;
    protected String site;
    //TODO later move to tables as well
    @Transient
    protected Humidex humidex;
    @Transient
    protected ThermoHumidityIndex thermoHumidityIndex;

    public Metrics() {
        this.humidex = new Humidex(getAirTemperature(), getRelevantHumidity());
        this.thermoHumidityIndex = new ThermoHumidityIndex(getAirTemperature(), getRelevantHumidity());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public double getAirTemperature() {
        return airTemperature;
    }

    public void setAirTemperature(double airTemperature) {
        this.airTemperature = airTemperature;
    }

    public double getRelevantHumidity() {
        return relevantHumidity;
    }

    public void setRelevantHumidity(double relevantHumidity) {
        this.relevantHumidity = relevantHumidity;
    }

    public double getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(double windDirection) {
        this.windDirection = windDirection;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public double getRadiation() {
        return radiation;
    }

    public void setRadiation(double radiation) {
        this.radiation = radiation;
    }

    public double getSphereTemperature() {
        return sphereTemperature;
    }

    public void setSphereTemperature(double sphereTemperature) {
        this.sphereTemperature = sphereTemperature;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public Humidex getHumidex() {
        return humidex;
    }

    public void setHumidex(Humidex humidex) {
        this.humidex = humidex;
    }

    public ThermoHumidityIndex getThermoHumidityIndex() {
        return thermoHumidityIndex;
    }

    public void setThermoHumidityIndex(ThermoHumidityIndex thermoHumidityIndex) {
        this.thermoHumidityIndex = thermoHumidityIndex;
    }
}
