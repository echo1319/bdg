package com.bgd.webapp.runtime.controllers;

import com.bgd.webapp.api.dto.Review;
import com.bgd.webapp.api.services.ReviewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class ReviewsController {
    @Autowired
    private ReviewsService reviewsService;

    @GetMapping(path = "/reviews", produces = "application/json")
    public ResponseEntity<List<Review>> getVisitors(@RequestParam(name = "date", required = false) String date,
                                                    @RequestParam(name = "startDate", required = false) String startDate,
                                                    @RequestParam(name = "endDate", required = false) String endDate) {

        List<Review> reviews = getReviews(date, startDate, endDate);
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    private List<Review> getReviews(String date, String startDate, String endDate) {
        List<Review> reviews;

        if (date != null) {
            reviews = reviewsService.getReviewsForDate(LocalDate.parse(date));
        } else if (startDate != null && endDate != null) {
            reviews = reviewsService.getReviewsByDateRange(LocalDate.parse(startDate), LocalDate.parse(endDate));
        } else if (startDate != null) {
            reviews = reviewsService.getReviewsByDateRange(LocalDate.parse(startDate), LocalDate.now());
        } else {
            reviews = reviewsService.getReviews();
        }
        return reviews;
    }
}
