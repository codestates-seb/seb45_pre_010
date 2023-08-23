package com.hexacoder.stackoverflow.question.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hexacoder.stackoverflow.question.entity.Question;

import com.hexacoder.stackoverflow.tag.dto.TagDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.time.format.DateTimeFormatter;
import com.hexacoder.stackoverflow.tag.entity.Tag;
import java.util.List;

public class AskQuestionDto {
    @Getter
    @AllArgsConstructor
    public static class Post {
        @NotBlank(message = "제목을 입력하세요.")
        private String title;
        @NotBlank (message = "내용을 입력하세요.")
        private String content;

        private Long userId;

        private List<TagDto> questionTag;
    }

    // 임시적 조치
    @Getter
    @AllArgsConstructor
    public static class Response {

        private Long questionId;

        private String title;

        private String content;

        private String createdAt;


        public Response(Question question) {
            this.questionId = question.getQuestionId();
            this.title = question.getTitle();
            this.content = question.getContent();
            this.createdAt = question.getCreatedAt().format(DateTimeFormatter.ofPattern("YYYY-mm-dd HH:MM:ss"));
        }



    }

    @Getter
    @AllArgsConstructor
    public static class TagDto {

        @Positive
        @JsonProperty(value = "tagId")
        private Long tagId;

        @JsonProperty(value = "tagName")
        private String tagName;
    }
}
