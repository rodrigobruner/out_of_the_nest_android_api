package com.conestoga.outofthenest.mapper;


import com.conestoga.outofthenest.model.Event;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EventMapper {

    @Insert("INSERT INTO events (title, description, datetime, latitude, longitude) " +
            "VALUES (#{title}, #{description}, #{datetime}, #{latitude}, #{longitude})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertEvent(Event event);

    @Select("SELECT * FROM events WHERE latitude BETWEEN #{lat} - #{radius} AND #{lat} + #{radius} " +
            "AND longitude BETWEEN #{lng} - #{radius} AND #{lng} + #{radius} " +
            "AND DATE(datetime) BETWEEN #{startDate} AND #{endDate}")
    List<Event> searchEvents(@Param("lat") double lat,
                             @Param("lng") double lng,
                             @Param("radius") double radius,
                             @Param("startDate") LocalDate startDate,
                             @Param("endDate") LocalDate endDate);
}
