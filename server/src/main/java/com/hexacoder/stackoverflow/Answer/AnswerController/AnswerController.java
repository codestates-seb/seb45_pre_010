package com.hexacoder.stackoverflow.Answer.AnswerController;

import com.hexacoder.stackoverflow.Answer.AnswerDto.AnswerPatchDto;
import com.hexacoder.stackoverflow.Answer.AnswerDto.AnswerPostDto;
import com.hexacoder.stackoverflow.Answer.AnswerDto.AnswerResponseDto;
import com.hexacoder.stackoverflow.Answer.AnswerEntity.Answer;
import com.hexacoder.stackoverflow.Answer.AnswerMapper.AnswerMapper;
import com.hexacoder.stackoverflow.Answer.AnswerService.AnswerService;
import com.hexacoder.stackoverflow.question.entity.Question;
import com.hexacoder.stackoverflow.question.service.QuestionService;
import com.hexacoder.stackoverflow.user.entity.UserEntity;
import com.hexacoder.stackoverflow.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/answer")
public class AnswerController {
    private final AnswerService answerService;
    private final AnswerMapper mapper;
    private final UserService userService;

    private final QuestionService questionService;


    public AnswerController(AnswerService answerService, AnswerMapper mapper,
                            UserService userService, QuestionService questionService) {
        this.answerService = answerService;
        this.mapper = mapper;
        this.userService = userService;
        this.questionService = questionService;
    }

    @PostMapping("/answer/{question-id}")
    public ResponseEntity createAnswer(@RequestBody @Valid AnswerPostDto post,
                                       @PathVariable("question-id") @Positive long questionId) {
        Answer postAnswer = mapper.answerPostDtoToAnswer(post);

        // user 객체 생성 또는 가져오는 로직 추가
        UserEntity user = userService.findUser(post.getUserId());
        postAnswer.setUser(user);

        Question question = questionService.findVerifiedQuestion(questionId);
        postAnswer.setQuestion(question);

        List<Answer> createdAnswers = answerService.createAnswer(postAnswer, questionId);
        Answer createdAnswer = createdAnswers.get(0);

        return new ResponseEntity(mapper.answerResponseDto(createdAnswer), HttpStatus.CREATED);
    }
    @GetMapping("/answers-for-question/{question-id}")
    public ResponseEntity<List<AnswerResponseDto>> getAnswersForQuestion(@PathVariable("question-id") @Positive long questionId) {
        List<Answer> answers = answerService.getAnswer(questionId);
        List<AnswerResponseDto> responseDtos = new ArrayList<>();

        for (Answer answer : answers) {
            AnswerResponseDto responseDto = mapper.answerResponseDto(answer);
            responseDtos.add(responseDto);
        }

        return new ResponseEntity<>(responseDtos, HttpStatus.OK);
    }

    @PostMapping("/{question-id}")
    public ResponseEntity postAnswer(@RequestBody @Valid AnswerPostDto post,
                                     @PathVariable("question-id") @Positive long questionId) {
        Answer postAnswer = mapper.answerPostDtoToAnswer(post);

        // user 객체 생성 또는 가져오는 로직 추가
        UserEntity user = userService.findUser(post.getUserId());
        postAnswer.setUser(user);

        Question question = questionService.findVerifiedQuestion(questionId);
        postAnswer.setQuestion(question);

        return new ResponseEntity(mapper.answerResponseDto(postAnswer), HttpStatus.CREATED);
    }

    @PatchMapping("{question-id}/{answer-id}")
    public ResponseEntity patchAnswer(@PathVariable("answer-id") @Positive long answerId,
                                      @PathVariable("question-id") @Positive long questionId,
                                      @RequestBody @Valid AnswerPatchDto patch) {
        Answer updatedAnswer = answerService.updateAnswer(answerId, patch.getContent(), questionId);
        AnswerResponseDto responseDto = mapper.answerResponseDto(updatedAnswer);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @DeleteMapping("/answers/{answer-id}")
    public ResponseEntity deleteAnswer(@PathVariable("answer-id") @Positive long answerId) {
        answerService.deleteAnswer(answerId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    }

