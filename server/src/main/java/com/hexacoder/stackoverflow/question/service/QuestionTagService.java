package com.hexacoder.stackoverflow.question.service;


import com.hexacoder.stackoverflow.question.repository.QuestionTagRepository;
import com.hexacoder.stackoverflow.tag.entity.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Slf4j
@Service
public class QuestionTagService {
    private final QuestionTagRepository questionTagRepository;

    public QuestionTagService(QuestionTagRepository questionTagRepository) {
        this.questionTagRepository = questionTagRepository;
    }

    public List<Tag> getTagsByQuestionId(Long questionId) {
        return questionTagRepository.findTagsByQuestionId(questionId);
    }

}
