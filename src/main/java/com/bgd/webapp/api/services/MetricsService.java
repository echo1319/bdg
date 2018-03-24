package com.bgd.webapp.api.services;

import com.bgd.webapp.api.dto.Metrics;

import java.time.LocalDateTime;
import java.util.List;

public interface MetricsService<T extends Metrics> {
    List<T> getAll();

    T getCurrentMetrics();

    List<T> getMetricsByDate(LocalDateTime localDateTime);

    List<T> getMetricsInRange(LocalDateTime startDate, LocalDateTime endDate);

}
