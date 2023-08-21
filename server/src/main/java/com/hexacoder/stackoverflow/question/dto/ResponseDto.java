package com.hexacoder.stackoverflow.question.dto;


import com.hexacoder.stackoverflow.question.entity.QuestionTag;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class ResponseDto {
    private List<QuestionTag> questionTags;
}
