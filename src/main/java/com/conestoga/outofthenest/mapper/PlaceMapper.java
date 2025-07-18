package com.conestoga.outofthenest.mapper;

import com.conestoga.outofthenest.model.Place;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PlaceMapper {

    void insertPlace(Place place);

    void insertTags(@Param("placeId") Long placeId, @Param("tags") List<String> tags);

    @Select("SELECT * FROM places WHERE id = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "tags", column = "id",
                    many = @Many(select = "com.conestoga.outofthenest.mapper.PlaceMapper.findTagsByPlaceId"))
    })
    Place findById(@Param("id") Long id);

    @Select("SELECT tag FROM place_tags WHERE place_id = #{placeId}")
    List<String> findTagsByPlaceId(@Param("placeId") Long placeId);

    List<Place> findNearbyPlaces(
            @Param("minLat") double minLat,
            @Param("maxLat") double maxLat,
            @Param("minLng") double minLng,
            @Param("maxLng") double maxLng,
            @Param("filters") List<String> filters,
            @Param("tags") List<String> tags
    );
}
