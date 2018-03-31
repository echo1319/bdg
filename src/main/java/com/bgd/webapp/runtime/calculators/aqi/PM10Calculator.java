package com.bgd.webapp.runtime.calculators.aqi;

import com.bgd.webapp.api.calculators.AqiCalculator;
import org.springframework.stereotype.Component;

@Component("PM10Calculator")
public class PM10Calculator implements AqiCalculator {

    @Override
    public double computeAQI(double value) {
        //ΡΜ10 (24 hr) μg/m3
        if (value >= 0 && value <= 54) {
            return 0.9259 * value;
        } else if (value >= 55 && value <= 154) {
            return (0.4949 * value) + 23.778;
        } else if (value >= 155 && value <= 254) {
            return (0.4949 * value) + 24.283;
        } else if (value >= 255 && value <= 354) {
            return (0.4949 * value) + 24.788;
        } else if (value >= 355 && value <= 424) {
            return (1.4349 * value) - 308.35;
        } else if (value >= 425 && value <= 604) {
            return (1.1117 * value) - 171.49;
        }
        throw new RuntimeException("PM10 values out of range : " + value);
    }
}
