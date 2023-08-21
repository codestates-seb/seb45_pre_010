package com.hexacoder.stackoverflow.question.dto;


import com.hexacoder.stackoverflow.user.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AllQuestionDto {

    private Long questionId;
    private String title;
    private String content;
    private long answerCount;
    private List<QuestionTagResponseDto> questionTag;


    @Setter
    private Long userId;

    @Setter
    private String nickname;
    private String createdAt;


    public void setUser(UserEntity user) {
        this.userId = user.getUserId();
        this.nickname = user.getNickname();
    }


}
