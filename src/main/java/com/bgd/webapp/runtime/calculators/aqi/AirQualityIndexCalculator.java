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
    private AqiCalculator coCalculator;
    @Autowired
    private AqiCalculator no2Calculator;
    @Autowired
    private AqiCalculator o3Calculator;
    @Autowired
    private AqiCalculator pm10Calculator;
    @Autowired
    private AqiCalculator so2Calculator;

    @Autowired
    private AirQualityCalculator airQualityCalculator;


    public AQI calculateAQI(double PM10Index, double O3Index, double NO2Index, double COIndex, double SO2Index) {
        double pm10Aqi = pm10Calculator.computeAQI(PM10Index);
        double soAqi = so2Calculator.computeAQI(SO2Index);
        double o3Aqi = o3Calculator.computeAQI(O3Index);
        double no2Aqi = no2Calculator.computeAQI(NO2Index);
        double coAqi = coCalculator.computeAQI(COIndex);

        ImmutableMap<POLLUTION_FACTORS, Double> indexMap = ImmutableMap.of(
            POLLUTION_FACTORS.PM10, pm10Aqi, POLLUTION_FACTORS.O3, o3Aqi,
            POLLUTION_FACTORS.NO2, no2Aqi, POLLUTION_FACTORS.CO, coAqi,
            POLLUTION_FACTORS.SO2, soAqi);

        Entry<POLLUTION_FACTORS, Double> aqiIndex = chooseMaxIndex(indexMap);

        AQI_AIR_QUALITY airQualityStatus = airQualityCalculator.computeStatus(aqiIndex.getValue());

        return new AQI(Math.round(aqiIndex.getValue()), airQualityStatus, aqiIndex.getKey());

    }


    private Map.Entry<POLLUTION_FACTORS, Double> chooseMaxIndex(Map<POLLUTION_FACTORS, Double> indexMap) {
        return indexMap.entrySet()
            .stream()
            .max(Comparator.comparing(Map.Entry::getValue))
            .get();
    }

}
