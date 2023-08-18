package com.hexacoder.stackoverflow.question.dto;


import com.hexacoder.stackoverflow.user.entity.UserEntity;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.Positive;


@Getter
@Setter
public class QuestionPostDto {

    @Positive
    private long userId;

    @Valid
    @NotNull
    private String title;


    @NotNull
    private String content;

    public UserEntity getUser() {
        UserEntity user = new UserEntity();
        user.setUserId(userId);
        return user;

    }
}