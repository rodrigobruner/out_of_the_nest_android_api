package com.conestoga.outofthenest.mapper;

import com.conestoga.outofthenest.model.Review;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ReviewMapper {
    void insertReview(Review review);
    List<Review> getReviewsByPlace(@Param("placeId") Long placeId);
}