package com.hexacoder.stackoverflow.Answer.AnswerDto;

import com.hexacoder.stackoverflow.question.entity.Question;
import com.hexacoder.stackoverflow.user.entity.UserEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Positive;
import java.time.LocalDateTime;

//@Builder
@Getter
@Setter
@NoArgsConstructor
public class AnswerResponseDto {
    @Positive
    private Long userId;
    private Long questionId;
    private Long answerId;
    private String content;
    private String nickname;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public void setUser(UserEntity user) {
        if (user != null) {
            this.userId = user.getUserId();
        }
    }

    public void setQuestion(Question question) {
        if (question != null) {
            this.questionId = question.getQuestionId();
        }
    }

//    public void setQuestion(Question question) {
//
//        this.questionId = question.getQuestionId();
//    }

}
