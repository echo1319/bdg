package com.bgd.webapp.runtime.calculators.aqi;

import com.bgd.webapp.api.calculators.AqiCalculator;
import com.bgd.webapp.api.indices.AQI;
import com.bgd.webapp.api.indices.AQI_AIR_QUALITY;
import com.bgd.webapp.api.indices.POLLUTION_FACTORS;
import com.google.common.collect.ImmutableMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.Map;

import static java.util.Map.Entry;

@Component
public class AirQualityIndexCalculator {
    @Autowired
    private AqiCalculator COCalculator;
    @Autowired
    private AqiCalculator NO2Calculator;
    @Autowired
    private AqiCalculator O3Calculator;
    @Autowired
    private AqiCalculator PM10Calculator;
    @Autowired
    private AqiCalculator SO2Calculator;


    public AQI calculateAQI(double PM10Index, double O3Index, double NO2Index, double COIndex, double SO2Index) {
        double pm10Aqi = PM10Calculator.computeAQI(PM10Index);
        double soAqi = SO2Calculator.computeAQI(SO2Index);
        double o3Aqi = O3Calculator.computeAQI(O3Index);
        double no2Aqi = NO2Calculator.computeAQI(NO2Index);
        double coAqi = COCalculator.computeAQI(COIndex);

        ImmutableMap<POLLUTION_FACTORS, Double> indexMap = ImmutableMap.of(
            POLLUTION_FACTORS.PM10, pm10Aqi, POLLUTION_FACTORS.O3, o3Aqi,
            POLLUTION_FACTORS.NO2, no2Aqi, POLLUTION_FACTORS.CO, coAqi,
            POLLUTION_FACTORS.SO2, soAqi);

        Entry<POLLUTION_FACTORS, Double> maxIndex = chooseMaxIndex(indexMap);
        POLLUTION_FACTORS chosenFactor = maxIndex.getKey();

        Double aqi = maxIndex.getValue();
        AQI_AIR_QUALITY airQualityStatus = computeAirQualityStatus(aqi);

        return new AQI(aqi, airQualityStatus, chosenFactor);

    }


    private AQI_AIR_QUALITY computeAirQualityStatus(double value) {
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


    private Map.Entry<POLLUTION_FACTORS, Double> chooseMaxIndex(Map<POLLUTION_FACTORS, Double> indexMap) {
        return indexMap.entrySet()
            .stream()
            .max(Comparator.comparing(Map.Entry::getValue))
            .get();
    }

}
