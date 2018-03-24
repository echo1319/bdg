package com.bgd.webapp.controllers;

import com.bgd.webapp.dto.GardenMetrics;
import com.bgd.webapp.services.GardenMetricsService;
import com.google.common.collect.ImmutableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class MetricsController {
    @Autowired
    private GardenMetricsService gardenMetricsService;

    @GetMapping(path = "/metrics/garden", produces = "application/json")
    public ResponseEntity<List<GardenMetrics>> getGardenMetrics(@RequestParam(name = "date", required = false) String date,
                                                                @RequestParam(name = "startDate", required = false) String startDate,
                                                                @RequestParam(name = "endDate", required = false) String endDate) {

        List<GardenMetrics> metrics = getMetrics(date, startDate, endDate);
        return new ResponseEntity<>(metrics, HttpStatus.OK);
    }

    private List<GardenMetrics> getMetrics(String date, String startDate, String endDate) {
        if (date != null) {
            return gardenMetricsService.getGardenMetricsByDate(LocalDateTime.parse(date));
        } else if (startDate != null && endDate != null) {
            return gardenMetricsService.getGardenMetricsInRange(LocalDateTime.parse(startDate), LocalDateTime.parse(endDate));
        } else if (startDate != null) {
            return gardenMetricsService.getGardenMetricsInRange(LocalDateTime.parse(startDate), LocalDateTime.now());
        }
        return  gardenMetricsService.getAll();
    }
}
