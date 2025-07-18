package com.conestoga.outofthenest.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Place {
    private Long id;
    private String title;
    private String description;
    private String type;
    private String address;
    private LocalDateTime datetime;
    private String distance;
    private String status;
    private Double rating;
    private Double latitude;
    private Double longitude;
    private Double delta;
    private List<String> tags;
}
