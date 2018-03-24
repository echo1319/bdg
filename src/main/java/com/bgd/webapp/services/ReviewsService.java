package com.bgd.webapp.services;

import com.bgd.webapp.dto.Review;

import java.time.LocalDate;
import java.util.List;

public interface ReviewsService {

    List<Review> getReviews();

    List<Review> getReviewsForDate(LocalDate date);

    List<Review> getReviewsByDateRange(LocalDate startDate, LocalDate endDate);
}
