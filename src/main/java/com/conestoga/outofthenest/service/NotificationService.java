package com.conestoga.outofthenest.service;


import com.conestoga.outofthenest.mapper.NotificationMapper;
import com.conestoga.outofthenest.model.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    @Autowired
    private NotificationMapper notificationMapper;

    public void sendEventNotification(Notification notification) {
        notificationMapper.insertNotification(notification);
    }
}