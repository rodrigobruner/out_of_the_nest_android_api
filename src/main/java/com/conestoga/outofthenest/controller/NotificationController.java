package com.conestoga.outofthenest.controller;

import com.conestoga.outofthenest.model.Notification;
import com.conestoga.outofthenest.service.NotificationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping("/getUserNotifications")
    public List<Notification> getUserNotifications(@RequestParam String userId) {
        return notificationService.getUserNotifications(userId);
    }
}
