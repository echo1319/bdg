package com.bgd.webapp.controllers;

import com.bgd.webapp.dto.VisitorCount;
import com.bgd.webapp.services.VisitorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class VisitorsController {
    @Autowired
    private VisitorsService visitorsService;

    @GetMapping(path = "/visitors", produces = "application/json")
    public ResponseEntity<List<VisitorCount>> getVisitors(@RequestParam(name = "week", required = false) Integer numberOfWeek,
                                                          @RequestParam(name = "day", required = false) String day,
                                                          @RequestParam(name = "date", required = false) String date,
                                                          @RequestParam(name = "startDate", required = false) String startDate,
                                                          @RequestParam(name = "endDate", required = false) String endDate) {
        List<VisitorCount> visitorCount = getVisitorCountsForAllSites(numberOfWeek, day, date, startDate, endDate);

        return new ResponseEntity<>(visitorCount, HttpStatus.OK);
    }

    private List<VisitorCount> getVisitorCountsForAllSites(@RequestParam(name = "week", required = false) Integer numberOfWeek, @RequestParam(name = "day", required = false) String day, @RequestParam(name = "date", required = false) String date, @RequestParam(name = "startDate", required = false) String startDate, @RequestParam(name = "endDate", required = false) String endDate) {
        List<VisitorCount> visitorCount;
        if (numberOfWeek != null && day != null) {
            visitorCount = visitorsService.getVisitorsByWeekAndDay(numberOfWeek, day);
        } else if (numberOfWeek != null) {
            visitorCount = visitorsService.getVisitorsByWeek(numberOfWeek);
        } else if (day != null) {
            visitorCount = visitorsService.getVisitorsByDay(day);
        } else if (date != null) {
            visitorCount = visitorsService.getVisitorsByDate(LocalDate.parse(date));
        } else if (startDate != null && endDate != null) {
            visitorCount = visitorsService.getVisitorsByDateRange(LocalDate.parse(startDate), LocalDate.parse(endDate));
        } else if (startDate != null) {
            visitorCount = visitorsService.getVisitorsByDateRange(LocalDate.parse(startDate), LocalDate.now());
        } else {
            visitorCount = visitorsService.getVisitors();
        }
        return visitorCount;
    }
}
