package com.hexacoder.stackoverflow.question.service;


import com.hexacoder.stackoverflow.question.entity.Question;
import com.hexacoder.stackoverflow.question.entity.QuestionTag;
import com.hexacoder.stackoverflow.question.repository.QuestionRepository;
import com.hexacoder.stackoverflow.question.repository.QuestionTagRepository;
import com.hexacoder.stackoverflow.tag.entity.Tag;
import com.hexacoder.stackoverflow.tag.repository.TagRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Slf4j
@Service
public class QuestionTagService {
    private final QuestionTagRepository questionTagRepository;
    private final TagRepository tagRepository;

    private final QuestionRepository questionRepository;

    public QuestionTagService(QuestionTagRepository questionTagRepository,
                              TagRepository tagRepository,
                              QuestionRepository questionRepository) {
        this.questionTagRepository = questionTagRepository;
        this.tagRepository = tagRepository;
        this.questionRepository = questionRepository;
    }

    public List<Tag> getTagsByQuestionId(Long questionId) {
        return questionTagRepository.findTagsByQuestionId(questionId);
    }

    public void createTagAndConnectToQuestion(String tagName, Long questionId) {
        Question question = questionRepository.findById(questionId).orElse(null);
        if (question != null) {
            // 새로운 태그 생성
            Tag tag = new Tag(tagName);
            tag = tagRepository.save(tag);

            // 질문과 태그 연결
            QuestionTag questionTag = new QuestionTag();
            questionTag.setQuestion(question);
            questionTag.setTag(tag);
            questionTagRepository.save(questionTag);
        } else {
            log.error("Question with ID {} not found.", questionId);
            // throw an exception or handle the error appropriately
        }
    }

}
