package com.conestoga.outofthenest.service;


import com.conestoga.outofthenest.mapper.TagMapper;
import com.conestoga.outofthenest.model.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {

    @Autowired
    private TagMapper tagMapper;

    public List<Tag> getTags() {
        return tagMapper.getTags();
    }
}