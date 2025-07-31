package com.conestoga.outofthenest.model;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Notification {
    private String userId;
    private String eventId;
    private String title;
    private String message;
    private LocalDateTime scheduledTime;
}
