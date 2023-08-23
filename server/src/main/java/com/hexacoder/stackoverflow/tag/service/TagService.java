package com.hexacoder.stackoverflow.tag.service;


import com.hexacoder.stackoverflow.exception.BusinessLogicException;
import com.hexacoder.stackoverflow.exception.ExceptionCode;
import com.hexacoder.stackoverflow.tag.dto.TagDto;
import com.hexacoder.stackoverflow.tag.entity.Tag;
import com.hexacoder.stackoverflow.tag.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TagService {
    private final TagRepository tagRepository;

    @Transactional
    public Long createTag(TagDto.Request requestBody) {
        Tag savedTag = tagRepository.save(requestBody.toEntity());
        return savedTag.getTagId();
    }

    @Transactional(readOnly = true)
    public Tag findTag(long tagId) {
        return findVerifiedTag(tagId);
    }

    public List<Tag> findTags() {
        return tagRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Tag findVerifiedTag(long tagId) {
        Optional<Tag> optionalTag =
                tagRepository.findById(tagId);
        Tag findTag =
                optionalTag.orElseThrow(() ->
                        new BusinessLogicException(ExceptionCode.TAG_NOT_FOUND));
        return findTag;
    }
}
