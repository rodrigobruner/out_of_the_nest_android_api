package com.conestoga.outofthenest.controller;


import com.conestoga.outofthenest.model.Notification;
import com.conestoga.outofthenest.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @PostMapping("/sendEventNotification")
    public void sendEventNotification(@RequestBody Notification notification) {
        notificationService.sendEventNotification(notification);
    }
}
