package com.bgd.webapp.api.repositories;

import com.bgd.webapp.api.dto.GardenAetherMetrics;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AetherGardenRepository extends CrudRepository<GardenAetherMetrics, String> {

    List<GardenAetherMetrics> findAllByDate(LocalDateTime localDateTime);

    List<GardenAetherMetrics> findAllByDateBetween(LocalDateTime startDate, LocalDateTime endDate);

}
