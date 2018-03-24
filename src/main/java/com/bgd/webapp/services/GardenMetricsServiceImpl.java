package com.bgd.webapp.services;

import com.bgd.webapp.dto.GardenMetrics;
import com.bgd.webapp.repositories.GardenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class GardenMetricsServiceImpl implements GardenMetricsService {

    @Autowired
    private GardenRepository gardenRepository;

    public static final int MINUTES_OFFSET = 10;

    @Override
    public List<GardenMetrics> getAll() {
        List<GardenMetrics> gardenMetrics = new ArrayList<>();
        gardenRepository.findAll().forEach(gardenMetrics::add);
        return gardenMetrics;
    }

    public GardenMetrics getCurrentGardenMetrics() {
        LocalDateTime now = LocalDateTime.now();
        return gardenRepository.findAllByDateBetween(now.minusMinutes(MINUTES_OFFSET), now).stream()
            .sorted().findFirst().get();
    }

    @Override
    public List<GardenMetrics> getGardenMetricsByDate(LocalDateTime localDateTime) {
        return gardenRepository.findAllByDate(localDateTime);
    }

    public List<GardenMetrics> getGardenMetricsInRange(LocalDateTime startDate, LocalDateTime endDate) {
        return gardenRepository.findAllByDateBetween(startDate, endDate);
    }

}
