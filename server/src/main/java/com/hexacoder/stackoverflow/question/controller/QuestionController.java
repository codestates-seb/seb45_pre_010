package com.hexacoder.stackoverflow.question.controller;


import com.hexacoder.stackoverflow.question.dto.*;
import com.hexacoder.stackoverflow.question.entity.Question;
import com.hexacoder.stackoverflow.question.mapper.QuestionMapper;
import com.hexacoder.stackoverflow.question.response.MultiResponseDto;
import com.hexacoder.stackoverflow.question.response.SingleResponseDto;
import com.hexacoder.stackoverflow.question.service.QuestionService;
import com.hexacoder.stackoverflow.question.service.QuestionTagService;
import com.hexacoder.stackoverflow.question.utils.UriCreator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping
@Validated
@Slf4j
public class QuestionController {

    private final QuestionService questionService;
    private final QuestionMapper questionMapper;

    private final QuestionTagService questionTagService;


    public QuestionController(QuestionService questionService, QuestionMapper questionMapper,
                              QuestionTagService questionTagService) {
        this.questionService = questionService;
        this.questionMapper = questionMapper;
        this.questionTagService = questionTagService;

    }



    //질문 등록
    @PostMapping("/questions/ask")
    public ResponseEntity postQuestion(
            UriComponentsBuilder uriComponentsBuilder,
            @Valid @RequestBody AskQuestionDto.Post requestBody) {

        Question question = questionService.createQuestion(requestBody);


        UriComponents uriComponents = uriComponentsBuilder.path("/questions/ask/{id}").buildAndExpand(question.getQuestionId());

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(uriComponents.toUri());
        return new ResponseEntity(httpHeaders, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity topQuestions(@Positive @RequestParam(defaultValue = "50") int size) {
        List<TopQuestionDto.Response> topQuestions = questionService.topQuestions(size);
        return new ResponseEntity<>(topQuestions, HttpStatus.OK);
    }

    @GetMapping("/questions")
    public ResponseEntity allQuestions(@Positive @RequestParam int page,
                                       @Positive @RequestParam int size) {
        AllResponseDto pageQuestions = questionService.findAllQuestions(page - 1, size);

        return new ResponseEntity<>(pageQuestions, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity getSearchQuestion(
            @Positive @RequestParam(required = false) int page,
            @Positive @RequestParam(required = false) int size,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String tag) {

        if(title != null ){
            AllResponseDto pagepageQuestions = questionService.findSearchQuestions(page - 1, size, title);
            return new ResponseEntity<>(pagepageQuestions, HttpStatus.OK);
        } else if(tag != null) {
            AllResponseDto pagepageQuestions = questionService.findSearchtagQuestions(page - 1, size, tag);
            return new ResponseEntity<>(pagepageQuestions, HttpStatus.OK);
        }
        else{
            AllResponseDto pageQuestions = questionService.findAllQuestions(page - 1, size);
            return new ResponseEntity<>(pageQuestions, HttpStatus.OK);
        }
    }

    @GetMapping("/questions/{question-id}")
    public ResponseEntity getQuestionDetail(
            @Positive @PathVariable("question-id") long questionId) {
        QuestionDetailDto questionDetailDto = questionService.findQuestionDetail(questionId);
        return new ResponseEntity<>(questionDetailDto, HttpStatus.OK);
    }

    @DeleteMapping("/questions/{question-id}")
    public ResponseEntity deleteQuestion(@PathVariable("question-id") @Positive long questionId) {
        questionService.deleteQuestion(questionId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }


    //질문 수정
   @PatchMapping("/questions/{question-id}")
   public ResponseEntity patchQuestion(
        @PathVariable("question-id") @Positive long questionId,
        @Valid @RequestBody QuestionPatchDto questionPatchDto) {

    Question updatedQuestion = questionService.updateQuestion(questionId, questionPatchDto);

    return new ResponseEntity<>(HttpStatus.OK);
}


}
