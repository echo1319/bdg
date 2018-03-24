package com.bgd.webapp.dto.indexes;

public class ThermoHumidityIndex {
    private static final double CONSTANT_A = 0.55;
    private static final double CONSTANT_B = 0.0055;
    private static final double CONSTANT_C = 14.5;
    private double value;
    private THI_STATUS thiStatus;

    public ThermoHumidityIndex(double airTemperature, double relevantHumidity) {
        value = computeTHI(airTemperature, relevantHumidity);
        thiStatus = computeThiStatus(value);
    }

    //THI = T - ( 0.55 –0.0055 * RH ) * ( T – 14.5 )
    private double computeTHI(double airTemperature, double relevantHumidity) {
        return airTemperature - (CONSTANT_A - (CONSTANT_B * relevantHumidity)) * (airTemperature - CONSTANT_C);
    }

    private THI_STATUS computeThiStatus(double thi) {
        if (thi < -40.0) {
            return THI_STATUS.SUPER_FREEZING;
        } else if (-39.9 <= thi && thi <= -20.0) {
            return THI_STATUS.FREEZING;
        } else if (-19.9 <= thi && thi <= -10.0) {
            return THI_STATUS.CRITICALLY_COLD;
        } else if (-9.9 <= thi && thi <= -1.8) {
            return THI_STATUS.VERY_COLD;
        } else if (-1.7 <= thi && thi <= 12.9) {
            return THI_STATUS.COLD;
        } else if (13.0 <= thi && thi <= 14.9) {
            return THI_STATUS.COOL;
        } else if (15.0 <= thi && thi <= 19.9) {
            return THI_STATUS.NORMAL;
        } else if (20.0 <= thi && thi <= 26.4) {
            return THI_STATUS.HOT;
        } else if (26.5 <= thi && thi <= 29.9) {
            return THI_STATUS.VERY_HOT;
        } else if (30.0 <= thi) {
            return THI_STATUS.DRY;
        }
        throw new RuntimeException("Illegal THI value : " + thi);
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
