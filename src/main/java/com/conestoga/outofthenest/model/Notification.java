package com.conestoga.outofthenest.model;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Notification {
    private Long id;
    private String userId;
    private String eventId;
    private String message;
    private LocalDateTime scheduledTime;
    private LocalDateTime createdAt;
}
