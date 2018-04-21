package com.bgd.webapp.runtime.controllers.rest;

import com.bgd.webapp.api.indices.AQI;
import com.bgd.webapp.api.indices.ERPI;
import com.bgd.webapp.api.indices.Humidex;
import com.bgd.webapp.runtime.MetricsAggregator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SuppressWarnings("unchecked")
@RestController
public class MetricsController {
    @Autowired
    private MetricsAggregator metricsAggregator;


    @GetMapping(path = "metrics/{site}/aqi", produces = "application/json")
    public ResponseEntity<AQI> getAQI(@PathVariable(name = "site") String site,
                                      @RequestParam(name = "date", required = false) String date,
                                      @RequestParam(name = "startDate", required = false) String startDate,
                                      @RequestParam(name = "endDate", required = false) String endDate) {

        return new ResponseEntity(metricsAggregator.calculateAqi(), HttpStatus.OK);
    }


    @GetMapping(path = "metrics/{site}/erpi", produces = "application/json")
    public ResponseEntity<ERPI> getERPI(@PathVariable(name = "site") String site,
                                        @RequestParam(name = "date", required = false) String date,
                                        @RequestParam(name = "startDate", required = false) String startDate,
                                        @RequestParam(name = "endDate", required = false) String endDate) {

        return new ResponseEntity(metricsAggregator.calculateERPI(), HttpStatus.OK);
    }


    @GetMapping(path = "metrics/{site}/humidex", produces = "application/json")
    public ResponseEntity<Humidex> getHUMIDEX(@PathVariable(name = "site") String site,
                                              @RequestParam(name = "date", required = false) String date,
                                              @RequestParam(name = "startDate", required = false) String startDate,
                                              @RequestParam(name = "endDate", required = false) String endDate) {

        return new ResponseEntity(metricsAggregator.calculateHumidex(), HttpStatus.OK);
    }


}
