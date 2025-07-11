package com.conestoga.outofthenest.service;


import com.conestoga.outofthenest.mapper.EventMapper;
import com.conestoga.outofthenest.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventMapper eventMapper;

    public Event createEvent(Event event) {
        eventMapper.insertEvent(event);
        return event;
    }

    public List<Event> searchEvents(double lat, double lng, double radius, LocalDate startDate, LocalDate endDate) {
        return eventMapper.searchEvents(lat, lng, radius, startDate, endDate);
    }
}
