package com.bgd.webapp.runtime;

import com.bgd.webapp.api.dto.AetherMetrics;
import com.bgd.webapp.api.dto.Metrics;
import com.bgd.webapp.api.indices.AQI;
import com.bgd.webapp.api.indices.ERPI;
import com.bgd.webapp.api.indices.Humidex;
import com.bgd.webapp.api.services.MetricsService;
import com.bgd.webapp.runtime.calculators.aqi.AirQualityIndexCalculator;
import com.bgd.webapp.runtime.calculators.erpi.EuropeanPollutionIndexCalculator;
import com.bgd.webapp.runtime.calculators.humidex.HumidexCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class MetricsAggregator {

    @Autowired
    private MetricsService gardenAetherMetricsService;


    @Autowired
    private MetricsService gardenMetricsService;

    @Autowired
    private HumidexCalculator humidexCalculator;

    @Autowired
    private EuropeanPollutionIndexCalculator erpiCalculator;

    @Autowired
    private AirQualityIndexCalculator aqiCalculator;


    public AQI calculateAqi() {
        AetherMetrics currentMetrics = (AetherMetrics) gardenAetherMetricsService.getCurrentMetrics();
        return aqiCalculator.calculateAQI(currentMetrics);
    }

    public ERPI calculateERPI() {
        List<AetherMetrics> dailyMetrics = (List<AetherMetrics>) gardenAetherMetricsService.getMetricsInRange(LocalDateTime.now().minusHours(24), LocalDateTime.now());
        return erpiCalculator.calculate(dailyMetrics);
    }

    public Humidex calculateHumidex() {
        Metrics currentMetrics = (Metrics) gardenMetricsService.getCurrentMetrics();
        return humidexCalculator.calculate(currentMetrics.getAirTemperature(), currentMetrics.getRelevantHumidity());
    }

}