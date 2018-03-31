package com.bgd.webapp.api.indices;

public class Humidex {
    private double value;
    private THERMAL_COMFORT thermalComfort;

    public Humidex(double value, THERMAL_COMFORT thermalComfort) {
        this.value = value;
        this.thermalComfort = thermalComfort;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public THERMAL_COMFORT getThermalComfort() {
        return thermalComfort;
    }

    public void setThermalComfort(THERMAL_COMFORT thermalComfort) {
        this.thermalComfort = thermalComfort;
    }
}
