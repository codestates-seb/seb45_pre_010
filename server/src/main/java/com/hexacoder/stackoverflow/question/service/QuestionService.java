package com.hexacoder.stackoverflow.question.service;


import com.hexacoder.stackoverflow.Answer.AnswerEntity.Answer;
import com.hexacoder.stackoverflow.question.dto.*;
import com.hexacoder.stackoverflow.question.entity.Question;
import com.hexacoder.stackoverflow.exception.BusinessLogicException;
import com.hexacoder.stackoverflow.exception.ExceptionCode;
import com.hexacoder.stackoverflow.question.mapper.QuestionMapper;
import com.hexacoder.stackoverflow.question.repository.QuestionRepository;
import com.hexacoder.stackoverflow.question.repository.QuestionTagRepository;
import com.hexacoder.stackoverflow.tag.entity.Tag;
import com.hexacoder.stackoverflow.tag.repository.TagRepository;
import com.hexacoder.stackoverflow.user.entity.UserEntity;
import com.hexacoder.stackoverflow.user.service.UserService;





import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;

@Transactional
@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    private final QuestionMapper questionMapper;

    private final UserService userService;

    private final QuestionTagRepository questionTagRepository;

    private final TagRepository tagRepository;

    private final QuestionTagService questionTagService;




    public QuestionService(QuestionRepository questionRepository, QuestionMapper questionMapper,
                           UserService userService, QuestionTagRepository questionTagRepository,
                           TagRepository tagRepository, QuestionTagService questionTagService) {
        this.questionRepository = questionRepository;
        this.questionMapper = questionMapper;
        this.userService = userService;
        this.questionTagRepository = questionTagRepository;
        this.tagRepository = tagRepository;
        this.questionTagService = questionTagService;
    }



    public Question createQuestion(AskQuestionDto.Post requestBody) {
        Question question = questionMapper.askquestionPostToQuestion(requestBody);
        UserEntity findUser = userService.findUser(requestBody.getUserId());

        question.addUser(findUser);

        List<AskQuestionDto.QuestionTagDto> questionTags = requestBody.getQuestionTag();
        if (questionTags == null || questionTags.isEmpty()) {
            throw new IllegalArgumentException("질문 태그가 비어있습니다.");
        }

        List<Tag> actualTags = new ArrayList<>();

        for (AskQuestionDto.QuestionTagDto tagDto : questionTags) {
            String tagName = tagDto.getTagName();
            if (tagName != null && !tagName.trim().isEmpty()) {
                Tag existingTag = tagRepository.findByTagName(tagName);
                if (existingTag == null) {
                    Tag tag = new Tag(tagName);
                    tag = tagRepository.save(tag);
                    actualTags.add(tag);
                } else {
                    // 이미 존재하는 태그라면 추가하지 않고 기존 태그만 사용
                    actualTags.add(existingTag);
                }
            }
        }

        if (actualTags.isEmpty()) {
            throw new IllegalArgumentException("질문 태그가 비어있습니다.");
        }

        question.addQuestionTags(actualTags);
        Question savedQuestion = questionRepository.save(question);
        return savedQuestion;
    }




    @Transactional(readOnly = true)
    public QuestionDetailDto findQuestionDetail(long questionId) {
        Question findQuestion = findQuestion(questionId);
        UserEntity findUser = userService.findUser(findQuestion.getUser().getUserId());
        List<Answer> finAnswerList = findQuestion.getAnswers();
        List<Tag> findTagList = questionTagService.getTagsByQuestionId(questionId);

        // 중복된 태그 제거
        Set<Tag> uniqueTags = new HashSet<>(findTagList);

        QuestionUserProfileDto questionUserProfileDto = new QuestionUserProfileDto();

        questionUserProfileDto.setQuestion(findQuestion);
        questionUserProfileDto.setUser(findUser);
        questionUserProfileDto.setAnswerList(finAnswerList);
        questionUserProfileDto.setTagList(new ArrayList<>(uniqueTags));

        return questionMapper.questionToResponse(questionUserProfileDto);
    }


    public Page<Question> findQuestions(int page, int size) {
        return questionRepository.findAll(
                PageRequest.of(page, size, Sort.by("questionId").descending()));
    }

    @Transactional
    public void deleteQuestion(long questionId) {
        Question findQuestion = findVerifiedQuestionByQuery(questionId);
        questionRepository.delete(findQuestion);
    }

    @Transactional(readOnly = true)
    public Question findVerifiedQuestionByQuery(long questionId) {
        Optional<Question> optionalQuestion = questionRepository.findByQuestion(questionId);
        Question findQuestion = optionalQuestion.orElseThrow(
                () -> new BusinessLogicException(ExceptionCode.QUESTION_NOT_FOUND));

        return findQuestion;
    }

    //readOnly: true -> get, gets
    //readOnly: false -> post, put, patch, delete
    @Transactional(readOnly = true)
    public List<TopQuestionDto.Response> topQuestions(int size) {
        // 쿼리로 createdAt 최신순(내림차순)으로 size(50)개 가져온 후 리턴
        List<Question> questions = questionRepository.findAll(Sort.by("createdAt").descending());
        List<TopQuestionDto.Response> topQuestions = new ArrayList<>();

        questions.stream().limit(size).forEach(question -> {
            UserEntity findUser = question.getUser();
            List<Answer> findAnswerList = question.getAnswers();
            QuestionUserProfileDto questionUserProfileDto = new QuestionUserProfileDto();
            List<Tag> findTagList = questionTagService.getTagsByQuestionId(question.getQuestionId());

            questionUserProfileDto.setQuestion(question);
            questionUserProfileDto.setUser(findUser);
            questionUserProfileDto.setAnswerList(findAnswerList);
            questionUserProfileDto.setTagList(findTagList);

            topQuestions.add(questionMapper.questionToTopQuestion(questionUserProfileDto));
        });

        return topQuestions;
    }


    @Transactional(readOnly = true)
    public AllResponseDto findAllQuestions(int page, int size) {
        Page<Question> questions = questionRepository.findAll(PageRequest.of(page, size,
                Sort.by("createdAt").descending()));

        AllResponseDto responseDtos =
                new AllResponseDto(questions.stream().map((q) ->
                        questionMapper.AllQuestionResponseDto(q)).collect(Collectors.toList()),
                        questions.getTotalPages(), questions.getTotalElements());

        return responseDtos;
    }


    //제목 질문 검색
    @Transactional(readOnly = true)
    public AllResponseDto findSearchQuestions(int page, int size, String title) {

        Pageable pageable = PageRequest.of(page, size, Sort.by("createdAt").descending());

        Page<Question> questions = questionRepository.findByTitleContaining(title, pageable);

        AllResponseDto responseDtos =
                new AllResponseDto(questions.stream().map((q) ->
                        questionMapper.AllQuestionResponseDto(q)).collect(Collectors.toList()),
                        questions.getTotalPages(), questions.getTotalElements());

        return responseDtos;
    }

    @Transactional(readOnly = true)
    public AllResponseDto findSearchtagQuestions(int page, int size, String tag) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("createdAt").descending());

        Tag findTag = tagRepository.findByTagName(tag);

        if(findTag == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "태그를 찾을 수 없습니다.");
        }

        Page<Question> questions = questionTagRepository.findQuestionsByTagId(findTag.getTagId(), pageable);

        AllResponseDto responseDtos =
                new AllResponseDto(questions.stream().map((q) ->
                        questionMapper.AllQuestionResponseDto(q)).collect(Collectors.toList()),
                        questions.getTotalPages(), questions.getTotalElements());

        return responseDtos;
    }



    @Transactional(readOnly = true)
    public Question findQuestion(long questionId) {
        return findVerifiedQuestion(questionId);
    }

    @Transactional(readOnly = true)
    public Question findVerifiedQuestion(long questionId) {
        Optional<Question> optionalQuestion = questionRepository.findById(questionId);
        Question findQuestion = optionalQuestion.orElseThrow(
                () -> new BusinessLogicException(ExceptionCode.USER_NOT_FOUND));

        return findQuestion;

    }


        //질문 업데이트
        @Transactional
        public Question updateQuestion(long questionId, QuestionPatchDto questionUpdateDto) {
            Question findQuestion = findVerifiedQuestion(questionId);

            // Update fields if present in the DTO
            if (questionUpdateDto.getTitle() != null) {
                findQuestion.setTitle(questionUpdateDto.getTitle());
            }
            if (questionUpdateDto.getContent() != null) {
                findQuestion.setContent(questionUpdateDto.getContent());
            }

            // Update modified time
            findQuestion.setModifiedAt(LocalDateTime.now());

            return questionRepository.save(findQuestion);
        }





}
