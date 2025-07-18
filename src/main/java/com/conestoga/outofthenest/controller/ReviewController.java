package com.conestoga.outofthenest.controller;


import com.conestoga.outofthenest.model.Review;
import com.conestoga.outofthenest.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping("/createReview")
    public Review createReview(@RequestBody Review review) {
        if (review.getDatetime() == null) {
        review.setDatetime(LocalDateTime.now());
        }
        reviewService.createReview(review);
        return review;
    }

    @GetMapping("/getReviewsByPlace")
    public List<Review> getReviewsByPlace(@RequestParam Long placeId) {
        return reviewService.getReviewsByPlace(placeId);
    }
}