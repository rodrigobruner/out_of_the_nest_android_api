package com.conestoga.outofthenest.service;


import com.conestoga.outofthenest.mapper.PlaceMapper;
import com.conestoga.outofthenest.model.Place;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PlaceService {

    @Autowired
    private PlaceMapper placeMapper;

    public Place createPlace(Place place) {
        placeMapper.insertPlace(place);
        if (place.getTags() != null && place.getId() != null) {
            placeMapper.insertTags(place.getId(), place.getTags());
        }
        return place;
    }

    public Place getPlace(Long id) {
        return placeMapper.findById(id);
    }

    public List<Place> getPlacesNear(Double lat, Double lng, Double delta, String filter) {
        Set<String> types = Arrays.stream(filter.split(",")).collect(Collectors.toSet());
        return placeMapper.findNearbyPlaces(lat, lng, delta, types);
    }
}