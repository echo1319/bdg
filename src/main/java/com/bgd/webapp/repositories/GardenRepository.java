package com.bgd.webapp.repositories;

import com.bgd.webapp.dto.GardenMetrics;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface GardenRepository extends CrudRepository<GardenMetrics, String> {

    List<GardenMetrics> findAllByDate(LocalDateTime localDateTime);

    List<GardenMetrics> findAllByDateBetween(LocalDateTime startDate, LocalDateTime endDate);

}
