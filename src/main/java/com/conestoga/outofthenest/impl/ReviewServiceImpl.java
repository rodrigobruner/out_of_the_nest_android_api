package com.conestoga.outofthenest.impl;


import com.conestoga.outofthenest.mapper.ReviewMapper;
import com.conestoga.outofthenest.model.Review;
import com.conestoga.outofthenest.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewMapper reviewMapper;

    @Override
    public Review createReview(Review review) {
        reviewMapper.insertReview(review);
        return review;
    }

    @Override
    public List<Review> getReviewsByPlace(Long placeId) {
        return reviewMapper.getReviewsByPlace(placeId);
    }
}
