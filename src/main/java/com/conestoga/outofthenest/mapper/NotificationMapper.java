package com.conestoga.outofthenest.mapper;


import com.conestoga.outofthenest.model.Notification;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NotificationMapper {

    @Insert("INSERT INTO notifications (user_id, event_id, message, scheduled_time, created_at) VALUES (#{userId}, #{eventId}, #{message}, #{scheduledTime}, NOW())")
    void insertNotification(Notification notification);
}