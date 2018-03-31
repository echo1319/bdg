package com.bgd.webapp.api.indices;

public class ThermoHumidityIndex {
    private double value;
    private THI_STATUS thiStatus;

    public ThermoHumidityIndex(double value, THI_STATUS status) {
        this.value = value;
        this.thiStatus = status;
    }


    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public THI_STATUS getThiStatus() {
        return thiStatus;
    }

    public void setThiStatus(THI_STATUS thiStatus) {
        this.thiStatus = thiStatus;
    }
}
