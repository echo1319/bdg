package com.bgd.webapp.services;

import com.bgd.webapp.dto.GardenMetrics;

import java.time.LocalDateTime;
import java.util.List;

public interface GardenMetricsService {
    GardenMetrics getCurrentGardenMetrics();

    List<GardenMetrics> getGardenMetricsByDate(LocalDateTime localDateTime);

    List<GardenMetrics> getGardenMetricsInRange(LocalDateTime startDate, LocalDateTime endDate);

}
