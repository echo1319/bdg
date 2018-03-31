package com.bgd.webapp.runtime.calculators.aqi;


import com.bgd.webapp.api.calculators.AqiCalculator;
import org.springframework.stereotype.Component;

@Component("O3Calculator")
public class O3Calculator implements AqiCalculator {

    //    O3 (8 hr)μg/m3

    public double computeAQI(double value) {
        if (value >= 0 && value <= 137) {
            return 0.3649 * value;
        } else if (value >= 138 && value <= 180) {
            return (1.1666 * value) - 110;
        } else if (value >= 181 && value <= 223) {
            return (1.1666 * value) - 110;
        } else if (value >= 224 && value <= 266) {
            return (1.1666 * value) - 110;
        } else if (value >= 267 && value <= 800) {
            return (0.1857 * value) + 151;
        } else if (value >= 800) {
            return (0.3758 * value);
        }
        throw new RuntimeException("O3 value not correct: " + value);
    }

}
