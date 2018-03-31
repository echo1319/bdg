package com.bgd.webapp.runtime.calculators.aqi;

import com.bgd.webapp.api.calculators.AqiCalculator;
import org.springframework.stereotype.Component;

@Component("COCalculator")
public class COCalculator implements AqiCalculator {
    @Override
    public double computeAQI(double value) {
        //CO (8 hr) mg/m3
        if (value >= 0 && value <= 5.5) {
            return 9.0909 * value;
        } else if (value >= 5.6 && value <= 11.76) {
            return (7.9545 * value) + 6.4545;
        } else if (value <= 11.77 && value >= 15.5) {
            return (13.1367 * value) - 53.62;
        } else if (value >= 15.6 && value <= 19.25) {
            return (13.4246 * value) - 58.42;
        } else if (value >= 19.26 && value <= 38.0) {
            return (5.2828 * value) + 99.253;
        } else if (value >= 38.1 && value <= 50.5) {
            return (16.0484 * value) - 310.4;
        }
        throw new RuntimeException("CO2 value out of range " + value);
    }
}
