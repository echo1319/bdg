package com.bgd.webapp.api.dto;

import com.bgd.webapp.api.dto.indexes.AirQualityIndex;
import com.bgd.webapp.api.dto.indexes.ERPollutionIndex;

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
public class AetherMetrics implements Serializable {
    @Id
    protected int id;
    @Column(name = "mdate")
    protected LocalDateTime date;
    protected double O3;
    protected double SO2;
    protected double NO2;
    protected double VOCs;
    protected double PM1;
    protected double PM25;
    protected double PM10;
    private double CO;
    protected double temperature;
    protected double humidity;
    protected double relativeHumidity;
    protected double pressure;
    protected double sound;

    @Transient
    protected ERPollutionIndex erPollutionIndex;

    @Transient
    protected AirQualityIndex airQualityIndex;

    public AetherMetrics() {
        erPollutionIndex = new ERPollutionIndex(PM10, O3, NO2, CO, SO2);
        airQualityIndex = new AirQualityIndex(PM10, O3, NO2, CO, SO2);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public double getO3() {
        return O3;
    }

    public void setO3(double o3) {
        O3 = o3;
    }

    public double getSO2() {
        return SO2;
    }

    public void setSO2(double SO2) {
        this.SO2 = SO2;
    }

    public double getNO2() {
        return NO2;
    }

    public void setNO2(double NO2) {
        this.NO2 = NO2;
    }

    public double getVOCs() {
        return VOCs;
    }

    public void setVOCs(double VOCs) {
        this.VOCs = VOCs;
    }

    public double getPM1() {
        return PM1;
    }

    public void setPM1(double PM1) {
        this.PM1 = PM1;
    }

    public double getPM25() {
        return PM25;
    }

    public void setPM25(double PM25) {
        this.PM25 = PM25;
    }

    public double getPM10() {
        return PM10;
    }

    public void setPM10(double PM10) {
        this.PM10 = PM10;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getRelativeHumidity() {
        return relativeHumidity;
    }

    public void setRelativeHumidity(double relativeHumidity) {
        this.relativeHumidity = relativeHumidity;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public double getSound() {
        return sound;
    }

    public void setSound(double sound) {
        this.sound = sound;
    }


    public ERPollutionIndex getErPollutionIndex() {
        return erPollutionIndex;
    }

    public void setErPollutionIndex(ERPollutionIndex erPollutionIndex) {
        this.erPollutionIndex = erPollutionIndex;
    }

    public AirQualityIndex getAirQualityIndex() {
        return airQualityIndex;
    }

    public void setAirQualityIndex(AirQualityIndex airQualityIndex) {
        this.airQualityIndex = airQualityIndex;
    }

    public double getCO() {
        return CO;
    }

    public void setCO(double CO) {
        this.CO = CO;
    }
}
