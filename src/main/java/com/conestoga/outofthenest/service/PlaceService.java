package com.conestoga.outofthenest.service;

import com.conestoga.outofthenest.mapper.PlaceMapper;
import com.conestoga.outofthenest.model.Place;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Place> getPlacesNear(double minLat, double maxLat, double minLng, double maxLng, List<String> filter, List<String> tags) {
        return placeMapper.findNearbyPlaces(minLat, maxLat, minLng, maxLng, filter, tags);
    }
}
