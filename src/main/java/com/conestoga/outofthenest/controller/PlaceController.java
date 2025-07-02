package com.conestoga.outofthenest.controller;


import com.conestoga.outofthenest.model.Place;
import com.conestoga.outofthenest.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/places")
public class PlaceController {

    @Autowired
    private PlaceService placeService;

    @PostMapping("/createPlace")
    public Place createPlace(@RequestBody Place place) {
        return placeService.createPlace(place);
    }

    @GetMapping("/getPlace")
    public Place getPlace(@RequestParam Long id) {
        return placeService.getPlace(id);
    }

    @GetMapping("/getPlacesNear")
    public List<Place> getPlacesNear(@RequestParam Double lat,
                                     @RequestParam Double lng,
                                     @RequestParam Double delta,
                                     @RequestParam String filter) {
        return placeService.getPlacesNear(lat, lng, delta, filter);
    }
}