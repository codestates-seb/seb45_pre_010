package com.hexacoder.stackoverflow.Answer.AnswerDto;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class AnswerPatchDto {
    private long answerId;
    private long userId;
    @NotNull
    private String content;
}
