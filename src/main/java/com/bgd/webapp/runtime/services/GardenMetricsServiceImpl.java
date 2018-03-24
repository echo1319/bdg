package com.bgd.webapp.runtime.services;

import com.bgd.webapp.api.dto.GardenMetrics;
import com.bgd.webapp.api.repositories.GardenRepository;
import com.bgd.webapp.api.services.MetricsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service("gardenMetricsService")
public class GardenMetricsServiceImpl implements MetricsService<GardenMetrics> {

    @Autowired
    private GardenRepository gardenRepository;

    public static final int MINUTES_OFFSET = 10;

    @Override
    public List<GardenMetrics> getAll() {
        List<GardenMetrics> gardenMetrics = new ArrayList<>();
        gardenRepository.findAll().forEach(gardenMetrics::add);
        return gardenMetrics;
    }

    @Override
    public GardenMetrics getCurrentMetrics() {
        LocalDateTime now = LocalDateTime.now();
        return gardenRepository.findAllByDateBetween(now.minusMinutes(MINUTES_OFFSET), now).stream()
            .sorted().findFirst().get();
    }

    @Override
    public List<GardenMetrics> getMetricsByDate(LocalDateTime localDateTime) {
        return gardenRepository.findAllByDate(localDateTime);
    }

    @Override
    public List<GardenMetrics> getMetricsInRange(LocalDateTime startDate, LocalDateTime endDate) {
        return gardenRepository.findAllByDateBetween(startDate, endDate);
    }

}
