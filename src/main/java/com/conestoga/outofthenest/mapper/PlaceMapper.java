package com.conestoga.outofthenest.mapper;

import com.conestoga.outofthenest.model.Place;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Set;

@Mapper
public interface PlaceMapper {
    void insertPlace(Place place);

    void insertTags(@Param("placeId") Long placeId, @Param("tags") List<String> tags);

    Place findById(@Param("id") Long id);

    List<Place> findNearbyPlaces(@Param("lat") Double lat,
                                 @Param("lng") Double lng,
                                 @Param("delta") Double delta,
                                 @Param("types") Set<String> types);
}