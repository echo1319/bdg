package com.bgd.webapp.runtime.controllers;

import com.bgd.webapp.api.dto.Metrics;
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

        return new ResponseEntity(getMetricsList(site, date, startDate, endDate), HttpStatus.OK);
    }


    private List<? extends Metrics> getMetricsList(String site, String date, String startDate, String endDate) {
        if (date != null) {
            resolveService(site).getMetricsByDate(LocalDateTime.parse(date));
        } else if (startDate != null && endDate != null) {
            resolveService(site).getMetricsInRange(LocalDateTime.parse(startDate), LocalDateTime.parse(endDate));
        } else if (startDate != null) {
            resolveService(site).getMetricsInRange(LocalDateTime.parse(startDate), LocalDateTime.now());
        }
        return resolveService(site).getAll();
    }

    private MetricsService resolveService(String path) {
        if (path.equals("garden")) {
            return gardenMetricsService;
        }
        return cityMetricsService;
    }

}
