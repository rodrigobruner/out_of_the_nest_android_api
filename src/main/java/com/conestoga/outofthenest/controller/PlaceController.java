package com.conestoga.outofthenest.controller;

import com.conestoga.outofthenest.model.Place;
import com.conestoga.outofthenest.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
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
    public List<Place> getPlacesNear(
            @RequestParam double latitude,
            @RequestParam double longitude,
            @RequestParam double delta,
            @RequestParam(required = false) String filter,
            @RequestParam(required = false) List<String> tags
    ) {
        double minLat = latitude - delta;
        double maxLat = latitude + delta;
        double minLng = longitude - delta;
        double maxLng = longitude + delta;
        List<String> filterList = (filter != null && !filter.isEmpty()) ? Arrays.asList(filter.split(",")) : null;
        return placeService.getPlacesNear(minLat, maxLat, minLng, maxLng, filterList, tags);
    }
}
