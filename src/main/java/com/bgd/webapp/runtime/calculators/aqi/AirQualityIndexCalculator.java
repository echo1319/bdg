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

    @Autowired
    private AirQualityCalculator airQualityCalculator;


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
        AQI_AIR_QUALITY airQualityStatus = airQualityCalculator.computeStatus(aqi);

        return new AQI(aqi, airQualityStatus, chosenFactor);

    }


    private Map.Entry<POLLUTION_FACTORS, Double> chooseMaxIndex(Map<POLLUTION_FACTORS, Double> indexMap) {
        return indexMap.entrySet()
            .stream()
            .max(Comparator.comparing(Map.Entry::getValue))
            .get();
    }

}
