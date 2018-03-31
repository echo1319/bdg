package com.bgd.webapp.runtime.calculators.aqi;

import com.bgd.webapp.api.calculators.AqiCalculator;
import org.springframework.stereotype.Component;

@Component("NO2Calculator")
public class NO2Calculator implements AqiCalculator {
    @Override
    public double computeAQI(double value) {
        // NO2 (1 hr) μg/m3
        if (value < 1330) {
            return 0;
        } else if (value >= 1330 && value <= 2542) {
            return (0.0817 * value) + 92.361;
        } else if (value >= 2543 && value <= 4182) {
            return (0.1214 * value) - 7.7596;
        }
        throw new RuntimeException("NO2 value out of range" + value);
    }
}
