package com.conestoga.outofthenest.model;

import lombok.Data;

@Data
public class Review {
    private Long id;
    private String title;
    private String description;
    private Integer rating;
    private String datetime;
    private String userId;
    private Long placeId;
}
