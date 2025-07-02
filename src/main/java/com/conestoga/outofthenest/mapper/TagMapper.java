package com.conestoga.outofthenest.mapper;

import com.conestoga.outofthenest.model.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TagMapper {
    @Select("SELECT name, icon FROM tags")
    List<Tag> getTags();
}