package com.hexacoder.stackoverflow.question.dto;


import com.hexacoder.stackoverflow.Answer.AnswerEntity.Answer;
import com.hexacoder.stackoverflow.question.entity.Question;
import com.hexacoder.stackoverflow.tag.entity.Tag;
import com.hexacoder.stackoverflow.user.entity.UserEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class QuestionUserProfileDto {
    private Question question;
    private UserEntity user;
    private List<Answer> answerList;
    private List<Tag> tagList;
}
