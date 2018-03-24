package com.bgd.webapp.api.services;

import java.time.LocalDateTime;
import java.util.List;

public interface MetricsService<T> {
    List<T> getAll();

    T getCurrentMetrics();

    List<T> getMetricsByDate(LocalDateTime localDateTime);

    List<T> getMetricsInRange(LocalDateTime startDate, LocalDateTime endDate);

}
