package com.bgd.webapp.api.indices;

public class ERPI {

    private double value;
    private ERPI_AIR_QUALITY air_quality;
    private POLLUTION_FACTORS chosenFactor;

    public ERPI() {
    }

    public ERPI(double value, ERPI_AIR_QUALITY air_quality, POLLUTION_FACTORS chosenFactor) {
        this.value = value;
        this.air_quality = air_quality;
        this.chosenFactor = chosenFactor;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public ERPI_AIR_QUALITY getAir_quality() {
        return air_quality;
    }

    public void setAir_quality(ERPI_AIR_QUALITY air_quality) {
        this.air_quality = air_quality;
    }

    public POLLUTION_FACTORS getChosenFactor() {
        return chosenFactor;
    }

    public void setChosenFactor(POLLUTION_FACTORS chosenFactor) {
        this.chosenFactor = chosenFactor;
    }
}
