package com.conestoga.outofthenest.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Review {
    private Long id;
    private String title;
    private String description;
    private Integer rating;
    private String userId;
    private Long placeId;
    private LocalDateTime datetime;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    public LocalDateTime getDatetime() {
        return datetime;
    }
}
