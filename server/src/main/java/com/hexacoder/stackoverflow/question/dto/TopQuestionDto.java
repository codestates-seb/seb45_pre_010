package com.hexacoder.stackoverflow.question.dto;

import com.hexacoder.stackoverflow.tag.entity.Tag;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

public class TopQuestionDto {

    @Getter
    @AllArgsConstructor
    public static class Response {

        private long questionId;
        private String title;
        private int count;
        private String nickname;
        private String createdAt;
        private List<Tag> questionTag;

    }
}
