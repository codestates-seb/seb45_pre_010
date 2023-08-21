package com.hexacoder.stackoverflow.question.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class TopQuestionDto {

    @Getter
    @AllArgsConstructor
    public static class Response {

        private long questionId;
        private String title;
        private int count;
        private String nickname;
        private String createdAt;

    }
}
