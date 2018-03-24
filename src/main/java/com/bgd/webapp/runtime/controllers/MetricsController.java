package com.bgd.webapp.runtime.controllers;

import com.bgd.webapp.api.dto.CityMetrics;
import com.bgd.webapp.api.dto.GardenMetrics;
import com.bgd.webapp.api.services.MetricsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@SuppressWarnings("unchecked")
@RestController
public class MetricsController {
    @Autowired
    private MetricsService gardenMetricsService;

    @Autowired
    private MetricsService cityMetricsService;

    @GetMapping(path = "/metrics/{site}", produces = "application/json")
    public ResponseEntity<List> getMetrics(@PathVariable(name = "site") String site,
                                           @RequestParam(name = "date", required = false) String date,
                                           @RequestParam(name = "startDate", required = false) String startDate,
                                           @RequestParam(name = "endDate", required = false) String endDate) {

        if (site.equals("garden")) {
            List<GardenMetrics> metrics = getGardenMetrics(date, startDate, endDate);
            return new ResponseEntity<>(metrics, HttpStatus.OK);
        }

        List<CityMetrics> cityMetrics = getCityMetrics(date, startDate, endDate);
        return new ResponseEntity<>(cityMetrics, HttpStatus.OK);
    }

    private List<GardenMetrics> getGardenMetrics(String date, String startDate, String endDate) {
        if (date != null) {
            return gardenMetricsService.getMetricsByDate(LocalDateTime.parse(date));
        } else if (startDate != null && endDate != null) {
            return gardenMetricsService.getMetricsInRange(LocalDateTime.parse(startDate), LocalDateTime.parse(endDate));
        } else if (startDate != null) {
            return gardenMetricsService.getMetricsInRange(LocalDateTime.parse(startDate), LocalDateTime.now());
        }
        return gardenMetricsService.getAll();
    }

    private List<CityMetrics> getCityMetrics(String date, String startDate, String endDate) {
        if (date != null) {
            return cityMetricsService.getMetricsByDate(LocalDateTime.parse(date));
        } else if (startDate != null && endDate != null) {
            return cityMetricsService.getMetricsInRange(LocalDateTime.parse(startDate), LocalDateTime.parse(endDate));
        } else if (startDate != null) {
            return cityMetricsService.getMetricsInRange(LocalDateTime.parse(startDate), LocalDateTime.now());
        }
        return cityMetricsService.getAll();
    }
}
