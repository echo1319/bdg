package com.bgd.webapp.api.repositories;

import com.bgd.webapp.api.dto.CityAetherMetrics;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AetherCityRepository extends CrudRepository<CityAetherMetrics, String> {

    List<CityAetherMetrics> findAllByDate(LocalDateTime localDateTime);


    List<CityAetherMetrics> findAllByDateBetween(LocalDateTime startDate, LocalDateTime endDate);

}
