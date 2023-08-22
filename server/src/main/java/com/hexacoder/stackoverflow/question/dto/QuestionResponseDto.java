package com.hexacoder.stackoverflow.question.dto;


import com.hexacoder.stackoverflow.question.entity.Question;
import com.hexacoder.stackoverflow.user.entity.UserEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
public class QuestionResponseDto {

    private long questionId;

    private long userId;

    private String title;

    private String content;

    private LocalDateTime createdAt;

    private Question.QuestionStatus questionStatus;

    public void setUser(UserEntity user) {
        this.userId = user.getUserId();
    }
}
