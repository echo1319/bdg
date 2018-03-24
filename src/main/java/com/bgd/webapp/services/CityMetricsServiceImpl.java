package com.bgd.webapp.services;

import com.bgd.webapp.dto.CityMetrics;
import com.bgd.webapp.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CityMetricsServiceImpl implements CityMetricsService {

    @Autowired
    private CityRepository cityRepository;

    public static final int MINUTES_OFFSET = 10;

    @Override
    public List<CityMetrics> getAll() {
        List<CityMetrics> cityMetrics = new ArrayList<>();
        cityRepository.findAll().forEach(cityMetrics::add);
        return cityMetrics;
    }

    public CityMetrics getCurrentCityMetrics() {
        LocalDateTime now = LocalDateTime.now();
        return cityRepository.findAllByDateBetween(now.minusMinutes(MINUTES_OFFSET), now).stream()
            .sorted().findFirst().get();
    }

    @Override
    public List<CityMetrics> getCityMetricsByDate(LocalDateTime localDateTime) {
        return cityRepository.findAllByDate(localDateTime);
    }

    public List<CityMetrics> getCityMetricsInRange(LocalDateTime startDate, LocalDateTime endDate) {
        return cityRepository.findAllByDateBetween(startDate, endDate);
    }

}
