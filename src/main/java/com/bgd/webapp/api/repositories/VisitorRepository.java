package com.bgd.webapp.api.repositories;


import com.bgd.webapp.api.dto.VisitorCount;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Transactional
@Repository
public interface VisitorRepository extends CrudRepository<VisitorCount, Integer> {
    @Query(value = "SELECT sum(v.VISITORS) FROM VISITOR v  WHERE v.DAY_OF_WEEK = ?1 GROUP BY v.DAY_OF_WEEK",
        nativeQuery = true)
    int sumByDay(String day);

    Iterable<VisitorCount> findAll();

    List<VisitorCount> findBySite(String sitename);

    List<VisitorCount> findByDayOfWeek(String day);

    List<VisitorCount> findByNumberOfWeek(int weekNumber);

    List<VisitorCount> findByNumberOfWeekAndDayOfWeek(int weekNumber, String dayOfWeek);

    List<VisitorCount> findByDate(LocalDate date);

    List<VisitorCount> findByDateBetween(LocalDate startDate, LocalDate endDate);

}
