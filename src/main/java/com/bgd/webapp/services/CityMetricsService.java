package com.bgd.webapp.services;

import com.bgd.webapp.dto.CityMetrics;
import com.bgd.webapp.dto.GardenMetrics;

import java.time.LocalDateTime;
import java.util.List;

public interface CityMetricsService {
    List<CityMetrics> getAll();

    CityMetrics getCurrentCityMetrics();

    List<CityMetrics> getCityMetricsByDate(LocalDateTime localDateTime);

    List<CityMetrics> getCityMetricsInRange(LocalDateTime startDate, LocalDateTime endDate);

}
