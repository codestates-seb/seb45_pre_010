package com.hexacoder.stackoverflow.tag.controller;


import com.hexacoder.stackoverflow.tag.dto.TagDto;
import com.hexacoder.stackoverflow.tag.entity.Tag;
import com.hexacoder.stackoverflow.tag.mapper.TagMapper;
import com.hexacoder.stackoverflow.tag.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tags")
public class TagController {

    private final TagService tagService;
    private final TagMapper tagMapper;


    @PostMapping
    public ResponseEntity createTag(@Valid @RequestBody TagDto.Request request) {
        return new ResponseEntity(tagService.createTag(request), HttpStatus.CREATED);
    }


    @GetMapping("/{tag_id}")
    public ResponseEntity getTag(@PathVariable("tag_id") @Positive long tagId) {
        Tag tag = tagService.findTag(tagId);
        return new ResponseEntity<>(tagMapper.tagToTagResponse(tag), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getTags() {
        List<Tag> tags = tagService.findTags();
        return new ResponseEntity<>(tagMapper.tagsToTagResponse(tags),HttpStatus.OK);
    }


}
