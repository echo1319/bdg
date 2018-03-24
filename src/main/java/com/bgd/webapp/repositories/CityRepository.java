package com.bgd.webapp.repositories;

import com.bgd.webapp.dto.CityMetrics;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CityRepository extends CrudRepository<CityMetrics, String> {

    List<CityMetrics> findAllByDate(LocalDateTime localDateTime);

    List<CityMetrics> findAllByDateBetween(LocalDateTime startDate, LocalDateTime endDate);

}
