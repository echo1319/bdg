package com.bgd.webapp.runtime.services;

import com.bgd.webapp.api.dto.CityAetherMetrics;
import com.bgd.webapp.api.repositories.AetherCityRepository;
import com.bgd.webapp.api.services.MetricsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service("cityAetherMetricsService")
public class CityAetherMetricsServiceImpl implements MetricsService<CityAetherMetrics> {

    @Autowired
    private AetherCityRepository aetherCityRepository;

    public static final int MINUTES_OFFSET = 10;

    @Override
    public List<CityAetherMetrics> getAll() {
        List<CityAetherMetrics> cityMetrics = new ArrayList<>();
        aetherCityRepository.findAll().forEach(cityMetrics::add);
        return cityMetrics;
    }

    @Override
    public CityAetherMetrics getCurrentMetrics() {
        LocalDateTime now = LocalDateTime.now();
        return aetherCityRepository.findAllByDateBetween(now.minusMinutes(MINUTES_OFFSET), now).stream()
            .sorted().findFirst().get();
    }

    @Override
    public List<CityAetherMetrics> getMetricsByDate(LocalDateTime localDateTime) {
        return aetherCityRepository.findAllByDate(localDateTime);
    }

    @Override
    public List<CityAetherMetrics> getMetricsInRange(LocalDateTime startDate, LocalDateTime endDate) {
        return aetherCityRepository.findAllByDateBetween(startDate, endDate);
    }

}
