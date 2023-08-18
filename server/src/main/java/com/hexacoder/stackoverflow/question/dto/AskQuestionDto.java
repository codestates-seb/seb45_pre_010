package com.hexacoder.stackoverflow.question.dto;

import com.hexacoder.stackoverflow.question.entity.Question;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import java.time.format.DateTimeFormatter;

public class AskQuestionDto {
    @Getter
    @AllArgsConstructor
    public static class Post {
        @NotBlank(message = "제목을 입력하세요.")
        private String title;
        @NotBlank (message = "내용을 입력하세요.")
        private String content;

        private Long userId;
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
}
