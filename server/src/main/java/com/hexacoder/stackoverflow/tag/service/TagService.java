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
        String tagName = requestBody.getTagName();

        // 이미 존재하는 태그인지 검사
        Tag existingTag = tagRepository.findByTagName(tagName);
        if (existingTag != null) {
            return existingTag.getTagId(); // 이미 존재하는 태그를 반환
        }

        // 존재하지 않는 태그라면 새로 생성
        Tag newTag = new Tag(tagName);
        Tag savedTag = tagRepository.save(newTag);
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
