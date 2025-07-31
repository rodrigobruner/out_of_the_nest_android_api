package com.conestoga.outofthenest.mapper;


import com.conestoga.outofthenest.model.Event;
import org.apache.ibatis.annotations.*;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface EventMapper {

    void insertEvent(Event event);

    void insertAudienceTags(@Param("eventId") String eventId, @Param("audienceTags") List<String> audienceTags);

    @Select("SELECT * FROM events WHERE id = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "targetAudience", column = "id",
                    many = @Many(select = "com.conestoga.outofthenest.mapper.EventMapper.getAudienceTags"))
    })
    Event getEventById(@Param("id") String id);

    List<Event> searchEvents(@Param("startDate") LocalDateTime startDate,
                             @Param("endDate") LocalDateTime endDate,
                             @Param("audience") List<String> audience);

    @Select("SELECT audience_tag FROM event_audience WHERE event_id = #{eventId}")
    List<String> getAudienceTags(@Param("eventId") String eventId);

    @Select("SELECT * FROM events")
    @Results(id = "EventWithAudience", value = {
            @Result(property = "id", column = "id"),
            @Result(property = "targetAudience", column = "id",
                    many = @Many(select = "getAudienceTags"))
    })
    List<Event> getAllEventsWithAudience();

}
