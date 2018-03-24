package com.bgd.webapp.api.services;

import com.bgd.webapp.api.dto.VisitorCount;

import java.time.LocalDate;
import java.util.List;

public interface VisitorsService {

    List<VisitorCount> getVisitors();

    List<VisitorCount> getVisitorsByDay(String dayOfWeek);


    List<VisitorCount> getVisitorsByWeek(int weekNumber);


    List<VisitorCount> getVisitorsByWeekAndDay(int weekNumber, String dayOfWeek);


    List<VisitorCount> getVisitorsByDate(LocalDate date);


    List<VisitorCount> getVisitorsByDateRange(LocalDate startDate, LocalDate endDate);


}
