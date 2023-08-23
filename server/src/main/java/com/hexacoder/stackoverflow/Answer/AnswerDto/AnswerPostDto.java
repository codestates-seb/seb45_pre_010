package com.hexacoder.stackoverflow.Answer.AnswerDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
@Getter
@Setter
@NoArgsConstructor
public class AnswerPostDto {

    @NotNull
    @Positive
    private Long questionId;

    @NotNull
    private Long userId;

    @NotBlank(message = "답변 내용을 적어주세요")
    private String content;

    public AnswerPostDto(Long questionId, Long userId, String content) {
        this.questionId = questionId;
        this.userId = userId;
        this.content = content;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setContent(String content) {
        this.content = content;
    }


}
