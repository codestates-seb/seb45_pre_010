package com.hexacoder.stackoverflow.question.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class QuestionTagResponseDto {
    private Long tagId;
    private String tagName;
    private String tagContent;

}