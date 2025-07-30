package com.conestoga.outofthenest.controller;


import com.conestoga.outofthenest.model.Event;
import com.conestoga.outofthenest.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {

    @Autowired
    private EventService eventService;

    @PostMapping("/createEvent")
    public String createEvent(@RequestBody Event event) {
        System.out.println("xxx");
        eventService.createEvent(event);
        return "OK";
    }

    @GetMapping("/getEvent")
    public Event getEvent(@RequestParam String id) {
        return eventService.getEvent(id);
    }

    @GetMapping("/searchEvents")
    public List<Event> searchEvents(@RequestParam String startDate,
                                    @RequestParam String endDate,
                                    @RequestParam(required = false) String targetAudience) {
        LocalDateTime start = LocalDate.parse(startDate).atStartOfDay();
        LocalDateTime end = LocalDate.parse(endDate).atTime(LocalTime.MAX);

        List<String> audience = null;
        if (targetAudience != null && !targetAudience.isEmpty()) {
            audience = Arrays.asList(targetAudience.split(","));
        }

        return eventService.searchEvents(start, end, audience);
    }
}
