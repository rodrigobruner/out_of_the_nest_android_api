package com.conestoga.outofthenest.controller;


import com.conestoga.outofthenest.model.Event;
import com.conestoga.outofthenest.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {

    @Autowired
    private EventService eventService;

    @PostMapping("/createEvent")
    public Event createEvent(@RequestBody Event event) {
        return eventService.createEvent(event);
    }

    @GetMapping("/searchEvents")
    public List<Event> searchEvents(@RequestParam double lat,
                                    @RequestParam double lng,
                                    @RequestParam double radius,
                                    @RequestParam String startDate,
                                    @RequestParam String endDate) {
        return eventService.searchEvents(lat, lng, radius, LocalDate.parse(startDate), LocalDate.parse(endDate));
    }
}