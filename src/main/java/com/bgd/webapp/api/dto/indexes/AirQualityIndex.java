package com.bgd.webapp.api.dto.indexes;

import com.google.common.collect.ImmutableMap;

import java.io.Serializable;
import java.util.Comparator;

import static java.util.Map.Entry;

public class AirQualityIndex implements Serializable {
    private double value;
    private String chosenIndex;
    private AQI_AIR_QUALITY airQualityStatus;
    private double PM10Index;
    private double O3Index;
    private double NO2Index;
    private double COIndex;
    private double SO2Index;

    public AirQualityIndex(double PM10, double O3, double NO2, double CO, double SO2) {
        PM10Index = computePM10Index(PM10);
        O3Index = computeO3Index(O3);
        NO2Index = computeNO2Index(NO2);
        COIndex = computeCOIndex(CO);
        SO2Index = computeSO2Index(SO2);

        Entry<String, Double> maxIndex = chooseMaxIndex();

        chosenIndex = maxIndex.getKey();
        value = maxIndex.getValue();
        airQualityStatus = computeAirQualityStatus(value);
    }

    //TODO: revisit with correct funtions
    private double computePM10Index(double PM10) {
        return PM10;
    }

    private double computeO3Index(double O3) {
        return (O3 * 50) / 120;
    }

    private double computeSO2Index(double so2) {
        return (so2 * 50) / 350;
    }

    private double computeCOIndex(double CO) {
        return (CO * 50) / 10;
    }

    private double computeNO2Index(double NO2) {
        return (NO2 * 50) / 200;
    }

    private Entry<String, Double> chooseMaxIndex() {
        ImmutableMap<String, Double> indexMap = ImmutableMap.of("PM10Index", PM10Index,
            "O3Index", O3Index, "NO2Index", NO2Index,
            "COIndex", COIndex, "SO2Index", SO2Index);

        return indexMap.entrySet()
            .stream()
            .max(Comparator.comparing(Entry::getValue))
            .get();
    }

    private AQI_AIR_QUALITY computeAirQualityStatus(double value) {
        if (value >= 0 && value <= 50) {
            return AQI_AIR_QUALITY.GOOD;
        } else if (value >= 51 && value <= 100) {
            return AQI_AIR_QUALITY.MEDIOCRE;
        } else if (value >= 101 && value <= 150) {
            return AQI_AIR_QUALITY.SLIGHTLY_HARMFUL;
        } else if (value >= 151 && value <= 200) {
            return AQI_AIR_QUALITY.HARMFUL;
        } else if (value >= 201 && value <= 300) {
            return AQI_AIR_QUALITY.VERY_HARMFUL;
        } else if (value >= 301 && value <= 500) {
            return AQI_AIR_QUALITY.DANGEROUSLY_HARMFUL;
        }

        throw new RuntimeException("Invalid AQI value " + value);
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getChosenIndex() {
        return chosenIndex;
    }

    public void setChosenIndex(String chosenIndex) {
        this.chosenIndex = chosenIndex;
    }

    public double getPM10Index() {
        return PM10Index;
    }

    public void setPM10Index(double PM10Index) {
        this.PM10Index = PM10Index;
    }

    public double getO3Index() {
        return O3Index;
    }

    public void setO3Index(double o3Index) {
        O3Index = o3Index;
    }

    public double getNO2Index() {
        return NO2Index;
    }

    public void setNO2Index(double NO2Index) {
        this.NO2Index = NO2Index;
    }

    public double getCOIndex() {
        return COIndex;
    }

    public void setCOIndex(double COIndex) {
        this.COIndex = COIndex;
    }

    public double getSO2Index() {
        return SO2Index;
    }

    public void setSO2Index(double SO2Index) {
        this.SO2Index = SO2Index;
    }

    public AQI_AIR_QUALITY getAirQualityStatus() {
        return airQualityStatus;
    }

    public void setAirQualityStatus(AQI_AIR_QUALITY airQualityStatus) {
        this.airQualityStatus = airQualityStatus;
    }
}
