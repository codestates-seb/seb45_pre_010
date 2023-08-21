package com.hexacoder.stackoverflow.question.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class AllResponseDto {

    private List<AllQuestionDto> data;
    private int totalPage;
    private long totalCount;

}