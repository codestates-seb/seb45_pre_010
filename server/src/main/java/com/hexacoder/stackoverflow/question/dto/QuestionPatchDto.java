package com.hexacoder.stackoverflow.question.dto;



import com.sun.istack.NotNull;
import lombok.Getter;

@Getter
public class QuestionPatchDto {

    private long questionId;

    @NotNull
    private String title;

    @NotNull
    private String content;

    public void setquestionId(long questionId) {
        this.questionId = questionId;
    }


}
