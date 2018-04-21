package com.bgd.webapp.runtime.controllers.rest;

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
public class TestMetricsController {
    @Autowired
    private MetricsService gardenMetricsService;

    @Autowired
    private MetricsService cityMetricsService;

    @Autowired
    private MetricsService gardenAetherMetricsService;

    @Autowired
    private MetricsService cityAetherMetricsService;


    @GetMapping(path = "test/metrics/{site}/{type}", produces = "application/json")
    public ResponseEntity<List> getMetrics(@PathVariable(name = "site") String site,
                                           @PathVariable(name = "type") String type,
                                           @RequestParam(name = "date", required = false) String date,
                                           @RequestParam(name = "startDate", required = false) String startDate,
                                           @RequestParam(name = "endDate", required = false) String endDate) {

        return new ResponseEntity(getMetricsList(site, type, date, startDate, endDate), HttpStatus.OK);
    }


    private List<? extends Metrics> getMetricsList(String site, String type, String date, String startDate, String endDate) {
        if (date != null) {
            resolveService(site, type).getMetricsByDate(LocalDateTime.parse(date));
        } else if (startDate != null && endDate != null) {
            resolveService(site, type).getMetricsInRange(LocalDateTime.parse(startDate), LocalDateTime.parse(endDate));
        } else if (startDate != null) {
            resolveService(site, type).getMetricsInRange(LocalDateTime.parse(startDate), LocalDateTime.now());
        }
        return resolveService(site, type).getAll();
    }




    private MetricsService resolveService(String site, String type) {
        if (site.equals("garden")) {
            if (type.equals("default")) {
                return gardenMetricsService;
            }
            return gardenAetherMetricsService;
        } else if (type.equals("aether")) {
            return cityAetherMetricsService;
        }
        return cityMetricsService;
    }

}
