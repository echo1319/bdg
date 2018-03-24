package com.bgd.webapp.runtime.services;

import com.bgd.webapp.api.dto.CityMetrics;
import com.bgd.webapp.api.repositories.CityRepository;
import com.bgd.webapp.api.services.MetricsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service("cityMetricsService")
public class CityMetricsServiceImpl implements MetricsService<CityMetrics> {

    @Autowired
    private CityRepository cityRepository;

    public static final int MINUTES_OFFSET = 10;

    @Override
    public List<CityMetrics> getAll() {
        List<CityMetrics> cityMetrics = new ArrayList<>();
        cityRepository.findAll().forEach(cityMetrics::add);
        return cityMetrics;
    }

    @Override
    public CityMetrics getCurrentMetrics() {
        LocalDateTime now = LocalDateTime.now();
        return cityRepository.findAllByDateBetween(now.minusMinutes(MINUTES_OFFSET), now).stream()
            .sorted().findFirst().get();
    }

    @Override
    public List<CityMetrics> getMetricsByDate(LocalDateTime localDateTime) {
        return cityRepository.findAllByDate(localDateTime);
    }

    @Override
    public List<CityMetrics> getMetricsInRange(LocalDateTime startDate, LocalDateTime endDate) {
        return cityRepository.findAllByDateBetween(startDate, endDate);
    }

}
