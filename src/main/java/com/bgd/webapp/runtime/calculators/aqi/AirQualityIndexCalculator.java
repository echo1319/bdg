package com.bgd.webapp.runtime.calculators.aqi;

import com.bgd.webapp.api.calculators.AqiCalculator;
import com.bgd.webapp.api.dto.AetherMetrics;
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


    public AQI calculateAQI(AetherMetrics aetherMetrics) {
        double pm10Aqi = pm10Calculator.computeAQI(aetherMetrics.getPM10());
        double soAqi = so2Calculator.computeAQI(aetherMetrics.getSO2());
        double o3Aqi = o3Calculator.computeAQI(aetherMetrics.getO3());
        double no2Aqi = no2Calculator.computeAQI(aetherMetrics.getNO2());
        double coAqi = coCalculator.computeAQI(aetherMetrics.getCO());

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
