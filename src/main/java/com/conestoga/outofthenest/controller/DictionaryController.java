package com.conestoga.outofthenest.controller;


import com.conestoga.outofthenest.model.Tag;
import com.conestoga.outofthenest.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dictionary")
public class DictionaryController {

    @Autowired
    private TagService tagService;

    @GetMapping("/getTags")
    public List<Tag> getTags() {
        return tagService.getTags();
    }
}