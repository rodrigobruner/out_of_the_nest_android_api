package com.conestoga.outofthenest.service;


import com.conestoga.outofthenest.model.Review;

import java.util.List;

public interface ReviewService {
    Review createReview(Review review);

    List<Review> getReviewsByPlace(Long placeId);
}