package com.conestoga.outofthenest.service;


import com.conestoga.outofthenest.mapper.EventMapper;
import com.conestoga.outofthenest.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class EventService {

    @Autowired
    private EventMapper eventMapper;

    public void createEvent(Event event) {
        event.setId("evt_" + UUID.randomUUID().toString().replace("-", "").substring(0, 8));
        eventMapper.insertEvent(event);
        if (event.getTargetAudience() != null && !event.getTargetAudience().isEmpty()) {
            eventMapper.insertAudienceTags(event.getId(), event.getTargetAudience());
        }
    }

    public Event getEvent(String id) {
        return eventMapper.getEventById(id);
    }

    public List<Event> searchEvents(LocalDateTime startDate, LocalDateTime endDate, List<String> audience) {
        List<Event> events = eventMapper.searchEvents(startDate, endDate, audience);
        for (Event event : events) {
            List<String> tags = eventMapper.getAudienceTags(event.getId());
            event.setTargetAudience(tags);
        }
        return events;
    }
}
