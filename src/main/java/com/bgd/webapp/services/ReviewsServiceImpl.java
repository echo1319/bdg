package com.bgd.webapp.services;

import com.bgd.webapp.dto.Review;
import com.bgd.webapp.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReviewsServiceImpl implements ReviewsService {
    @Autowired
    private ReviewRepository reviewRepository;

    public List<Review> getReviews() {
        List<Review> reviews = new ArrayList<>();
        reviewRepository.findAll().iterator().forEachRemaining(reviews::add);
        return reviews;
    }

    public List<Review> getReviewsForDate(LocalDate date) {
        return reviewRepository.findByDate(date);
    }

    public List<Review> getReviewsByDateRange(LocalDate startDate, LocalDate endDate) {
        return reviewRepository.findByDateBetween(startDate, endDate);
    }

}
