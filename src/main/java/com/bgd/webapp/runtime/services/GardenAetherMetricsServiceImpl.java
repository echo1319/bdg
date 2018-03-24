package com.bgd.webapp.runtime.services;

import com.bgd.webapp.api.dto.GardenAetherMetrics;
import com.bgd.webapp.api.repositories.AetherGardenRepository;
import com.bgd.webapp.api.services.MetricsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service("gardenAetherMetricsService")
public class GardenAetherMetricsServiceImpl implements MetricsService<GardenAetherMetrics> {

    @Autowired
    private AetherGardenRepository aetherGardenRepository;

    public static final int MINUTES_OFFSET = 10;

    @Override
    public List<GardenAetherMetrics> getAll() {
        List<GardenAetherMetrics> metrics = new ArrayList<>();
        aetherGardenRepository.findAll().forEach(metrics::add);
        return metrics;
    }

    @Override
    public GardenAetherMetrics getCurrentMetrics() {
        LocalDateTime now = LocalDateTime.now();
        return aetherGardenRepository.findAllByDateBetween(now.minusMinutes(MINUTES_OFFSET), now).stream()
            .sorted().findFirst().get();
    }

    @Override
    public List<GardenAetherMetrics> getMetricsByDate(LocalDateTime localDateTime) {
        return aetherGardenRepository.findAllByDate(localDateTime);
    }

    @Override
    public List<GardenAetherMetrics> getMetricsInRange(LocalDateTime startDate, LocalDateTime endDate) {
        return aetherGardenRepository.findAllByDateBetween(startDate, endDate);
    }

}
