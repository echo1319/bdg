package com.bgd.webapp.runtime.calculators.aqi;

import com.bgd.webapp.api.calculators.AqiCalculator;
import org.springframework.stereotype.Component;

@Component("so2Calculator")
public class SO2Calculator implements AqiCalculator {
    @Override
    public double computeAQI(double value) {
        //  SO2 (24 hr) μg/m3
        if (value >= 0 && value <= 97) {
            return 0.5154 * value;
        } else if (value >= 98 && value <= 412) {
            return (0.156 * value) + 35.7;
        } else if (value >= 413 && value <= 640) {
            return (0.2158 * value) + 11.85;
        } else if (value >= 641 && value <= 869) {
            return (0.2149 * value) + 13.2;
        } else if (value >= 870 && value <= 1727) {
            return (0.1155 * value) + 100.5;
        } else if (value >= 1728 && value <= 2300) {
            return (0.3479 * value) - 300.2;
        }

        throw new RuntimeException("SO2 value out of range " + value);
    }
}
