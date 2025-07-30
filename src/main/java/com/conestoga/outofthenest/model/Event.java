package com.conestoga.outofthenest.model;


import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Event {
    private String id;
    private String title;
    private String description;
    private LocalDateTime datetime;
    private String address;
    private List<String> targetAudience;
}