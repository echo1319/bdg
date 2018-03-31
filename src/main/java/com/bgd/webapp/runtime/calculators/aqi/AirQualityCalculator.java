package com.bgd.webapp.runtime.calculators.aqi;

import com.bgd.webapp.api.indices.AQI_AIR_QUALITY;
import org.springframework.stereotype.Component;

@Component
public class AirQualityCalculator {

    public AQI_AIR_QUALITY computeStatus(double value) {
        if (value >= 0 && value <= 50) {
            return AQI_AIR_QUALITY.GOOD;
        } else if (value >= 51 && value <= 100) {
            return AQI_AIR_QUALITY.MEDIOCRE;
        } else if (value >= 101 && value <= 150) {
            return AQI_AIR_QUALITY.SLIGHTLY_HARMFUL;
        } else if (value >= 151 && value <= 200) {
            return AQI_AIR_QUALITY.HARMFUL;
        } else if (value >= 201 && value <= 300) {
            return AQI_AIR_QUALITY.VERY_HARMFUL;
        } else if (value >= 301 && value <= 500) {
            return AQI_AIR_QUALITY.DANGEROUSLY_HARMFUL;
        }
        throw new RuntimeException("Invalid AQI value " + value);
    }
}
