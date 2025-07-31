package com.conestoga.outofthenest.mapper;


import com.conestoga.outofthenest.model.Notification;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface NotificationMapper {

    @Insert("INSERT INTO notifications (user_id, event_id, message, scheduled_time, created_at) VALUES (#{userId}, #{eventId}, #{message}, #{scheduledTime}, NOW())")
    void insertNotification(Notification notification);
//
    @Select("SELECT title,description,datetime,address FROM events")
    List<Notification> getNotification(String userId);
}