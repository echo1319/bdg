package com.bgd.webapp.api.repositories;


import com.bgd.webapp.api.dto.Review;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Transactional
@Repository
public interface ReviewRepository extends CrudRepository<Review, Integer> {

    Iterable<Review> findAll();

    List<Review> findByDate(LocalDate date);

    List<Review> findByDateBetween(LocalDate startDate, LocalDate endDate);

}
