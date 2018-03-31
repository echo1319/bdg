package com.bgd.webapp.runtime.calculators.erpi;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ERPICalculator {
    private static final double NO2_LIMIT = 200;
    private static final double SO2_LIMIT = 350;
    private static final double CO_LIMIT = 10;
    private static final double O3_LIMIT = 120;
    private static final double PM10_LIMIT = 50;

    public double calculateNO2ERPI(List<Double> metrics) {
        double average = getAverage(metrics);
        return computeERPI(average, NO2_LIMIT);
    }

    public double calculateSO2ERPI(List<Double> metrics) {
        double average = getAverage(metrics);
        return computeERPI(average, SO2_LIMIT);
    }

    public double calculateCOERPI(List<Double> metrics) {
        double average = getAverage(metrics);
        return computeERPI(average, CO_LIMIT);
    }

    public double calculateO3ERPI(List<Double> metrics) {
        double average = getAverage(metrics);
        return computeERPI(average, O3_LIMIT);
    }

    public double calculatePM10ERPI(List<Double> metrics) {
        double average = getAverage(metrics);
        return computeERPI(average, PM10_LIMIT);
    }

    private double getAverage(List<Double> metrics) {
        double sum = metrics.stream().mapToDouble(Double::doubleValue).sum();
        return sum / (double) metrics.size();
    }

    private double computeERPI(double avg, double limit) {
        return (avg / limit) * 50;
    }


}
