package com.bgd.webapp.api.indices;

public class AQI {
    private double value;
    private AQI_AIR_QUALITY airQuality;
    private POLLUTION_FACTORS chosenFactor;

    public AQI(double value, AQI_AIR_QUALITY airQuality, POLLUTION_FACTORS chosenFactor) {
        this.value = value;
        this.airQuality = airQuality;
        this.chosenFactor = chosenFactor;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public AQI_AIR_QUALITY getAirQuality() {
        return airQuality;
    }

    public void setAirQuality(AQI_AIR_QUALITY airQuality) {
        this.airQuality = airQuality;
    }

    public POLLUTION_FACTORS getChosenFactor() {
        return chosenFactor;
    }

    public void setChosenFactor(POLLUTION_FACTORS chosenFactor) {
        this.chosenFactor = chosenFactor;
    }
}
