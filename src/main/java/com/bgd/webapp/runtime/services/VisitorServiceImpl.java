package com.bgd.webapp.runtime.services;

import com.bgd.webapp.api.dto.VisitorCount;
import com.bgd.webapp.api.repositories.VisitorRepository;
import com.bgd.webapp.api.services.VisitorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class VisitorServiceImpl implements VisitorsService {

    @Autowired
    private VisitorRepository visitorRepository;

    @Override
    public List<VisitorCount> getVisitors() {
        List<VisitorCount> visitorCounts = new ArrayList<>();
        visitorRepository.findAll().iterator().forEachRemaining(visitorCounts::add);
        return visitorCounts;
    }

    @Override
    public List<VisitorCount> getVisitorsByDay(String dayOfWeek) {
        return visitorRepository.findByDayOfWeek(dayOfWeek);
    }

    @Override
    public List<VisitorCount> getVisitorsByWeek(int weekNumber) {
        return visitorRepository.findByNumberOfWeek(weekNumber);
    }

    @Override
    public List<VisitorCount> getVisitorsByWeekAndDay(int weekNumber, String dayOfWeek) {
        return visitorRepository.findByNumberOfWeekAndDayOfWeek(weekNumber, dayOfWeek);
    }

    @Override
    public List<VisitorCount> getVisitorsByDate(LocalDate date) {
        return visitorRepository.findByDate(date);
    }

    @Override
    public List<VisitorCount> getVisitorsByDateRange(LocalDate startDate, LocalDate endDate) {
        return visitorRepository.findByDateBetween(startDate, endDate);
    }
}
