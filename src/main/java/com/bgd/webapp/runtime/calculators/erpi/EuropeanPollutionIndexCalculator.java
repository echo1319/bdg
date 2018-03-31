package com.bgd.webapp.runtime.calculators.erpi;

import com.bgd.webapp.api.dto.AetherMetrics;
import com.bgd.webapp.api.indices.ERPI;
import com.bgd.webapp.api.indices.ERPI_AIR_QUALITY;
import com.bgd.webapp.api.indices.POLLUTION_FACTORS;
import com.google.common.collect.ImmutableMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class EuropeanPollutionIndexCalculator {

    @Autowired
    private ERPICalculator erpiCalculator;

    public ERPI calculate(List<AetherMetrics> dailyMetrics) {

        LocalDateTime currentTime = LocalDateTime.now();

        List<AetherMetrics> hourlyMetrics = dailyMetrics.stream()
            .filter(aetherMetrics -> aetherMetrics.getDate().isAfter(currentTime.minusHours(1)))
            .collect(Collectors.toList());

        // get metics per hour/date /etc for each and delegate them
        double no2Index = calculateNO2(hourlyMetrics);
        double so2Index = calculateSO2(hourlyMetrics);


        List<AetherMetrics> eightlyMetrics = dailyMetrics.stream()
            .filter(aetherMetrics -> aetherMetrics.getDate().isAfter(currentTime.minusHours(8)))
            .collect(Collectors.toList());

        double o3Index = calculateO3(eightlyMetrics);
        double coIndex = calculateCO(eightlyMetrics);


        double pm10Index = calculatePM10(dailyMetrics);

        Map.Entry<POLLUTION_FACTORS, Double> erpiIndex =
            chooseMaxIndex(pm10Index, o3Index, no2Index, coIndex, so2Index);

        ERPI_AIR_QUALITY airQuality = computeAirQualityStatus(erpiIndex.getValue());

        return new ERPI(erpiIndex.getValue(), airQuality, erpiIndex.getKey());
    }


    private double calculateNO2(List<AetherMetrics> metrics) {
        List<Double> values =
            metrics.stream().map(AetherMetrics::getNO2).collect(Collectors.toList());
        return erpiCalculator.calculateNO2ERPI(values);
    }


    private double calculateSO2(List<AetherMetrics> metrics) {
        List<Double> values = metrics.stream().map(AetherMetrics::getSO2).collect(Collectors.toList());
        return erpiCalculator.calculateSO2ERPI(values);
    }


    private double calculateO3(List<AetherMetrics> metrics) {
        List<Double> values = metrics.stream().map(AetherMetrics::getO3).collect(Collectors.toList());
        return erpiCalculator.calculateO3ERPI(values);
    }

    private double calculatePM10(List<AetherMetrics> metrics) {
        List<Double> values = metrics.stream().map(AetherMetrics::getPM10).collect(Collectors.toList());
        return erpiCalculator.calculatePM10ERPI(values);
    }


    private double calculateCO(List<AetherMetrics> metrics) {
        List<Double> values = metrics.stream().map(AetherMetrics::getCO).collect(Collectors.toList());
        return erpiCalculator.calculateCOERPI(values);
    }


    private ERPI_AIR_QUALITY computeAirQualityStatus(double value) {
        if (value > 0 && value < 2) {
            return ERPI_AIR_QUALITY.VERY_HIGH;
        } else if (value >= 2 && value < 21) {
            return ERPI_AIR_QUALITY.HIGH;
        } else if (value >= 21 && value < 40) {
            return ERPI_AIR_QUALITY.SATISFACTORY;
        } else if (value >= 40 && value < 60) {
            return ERPI_AIR_QUALITY.ADEQUATE;
        } else if (value >= 60 && value < 79) {
            return ERPI_AIR_QUALITY.LOW;
        } else if (value >= 79) {
            return ERPI_AIR_QUALITY.VERY_LOW;
        }

        throw new RuntimeException("Invalid ERPI value " + value);
    }

    private Map.Entry<POLLUTION_FACTORS, Double> chooseMaxIndex(double pm10Index, double o3Index, double no2Index, double coIndex, double so2Index) {

        ImmutableMap<POLLUTION_FACTORS, Double> indexMap = ImmutableMap.of(
            POLLUTION_FACTORS.PM10, pm10Index, POLLUTION_FACTORS.O3, o3Index,
            POLLUTION_FACTORS.NO2, no2Index, POLLUTION_FACTORS.CO, coIndex,
            POLLUTION_FACTORS.SO2, so2Index);

        return indexMap.entrySet()
            .stream()
            .max(Comparator.comparing(Map.Entry::getValue))
            .get();
    }


}
