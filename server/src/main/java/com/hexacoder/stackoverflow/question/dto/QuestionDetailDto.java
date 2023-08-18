package com.hexacoder.stackoverflow.question.dto;


import com.hexacoder.stackoverflow.Answer.AnswerDto.AnswerResponseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class QuestionDetailDto {
    private long questionId;
    private String title;
    private String content;
    private long userId;
    private String nickname;
    private List<AnswerResponseDto> answerList;
    private String createdAt;
}
