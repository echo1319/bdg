package com.bgd.webapp.runtime.calculators.humidex;

import com.bgd.webapp.api.indices.Humidex;
import com.bgd.webapp.api.indices.THERMAL_COMFORT;
import org.springframework.stereotype.Component;

@Component
public class HumidexCalculator {

    public Humidex calculate(double airTemperature, double relevantHumidity) {
        double value = computeHumidex(airTemperature, relevantHumidity);
        THERMAL_COMFORT thermalComfort = computeThermalComfort(value);
        return new Humidex(value, thermalComfort);
    }

    // H=T+0.5555*[((6.112*10[(7.5*T)/(237.7+T)]*RH)/100)-10.0]
    private double computeHumidex(double airTemperature, double relevantHumidity) {
        double power = ((7.5 * airTemperature) / (237.7 + airTemperature));
        double product = ((6.112 * Math.pow(10, power) * relevantHumidity) / 100);
        return airTemperature + (0.5555 * (product - 10.0));
    }

    private THERMAL_COMFORT computeThermalComfort(double value) {
        if (value < 27.0) {
            return THERMAL_COMFORT.NORMAL;
        } else if (27.0 <= value && value <= 29.9) {
            return THERMAL_COMFORT.SLIGHTLY_UNCOMFORTABLE;
        } else if (30.0 <= value && value <= 39.9) {
            return THERMAL_COMFORT.VERY_UNCOMFORTABLE;
        } else if (40.0 <= value && value <= 54.9) {
            return THERMAL_COMFORT.DANGER;
        } else if (value >= 55.0) {
            return THERMAL_COMFORT.HIGH_DANGER;
        }
        throw new RuntimeException("Illegal Humidex value :" + value);
    }


}
