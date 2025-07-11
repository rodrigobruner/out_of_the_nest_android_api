package com.conestoga.outofthenest.model;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Event {
    private Long id;
    private String title;
    private String description;
    private LocalDateTime datetime;
    private Double latitude;
    private Double longitude;
}