package com.hexacoder.stackoverflow.Answer.AnswerMapper;
    
import com.hexacoder.stackoverflow.Answer.AnswerDto.AnswerPatchDto;
import com.hexacoder.stackoverflow.Answer.AnswerDto.AnswerPostDto;
import com.hexacoder.stackoverflow.Answer.AnswerDto.AnswerResponseDto;
import com.hexacoder.stackoverflow.Answer.AnswerEntity.Answer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Mapper(componentModel = "spring")
public interface AnswerMapper {

    Answer answerPostDtoToAnswer(AnswerPostDto answerPostDto);
    Answer answerPatchDtoToAnswer(AnswerPatchDto answerPatchDto);
    @Mapping(source = "user.userId", target = "userId")
    @Mapping(source = "question.questionId", target = "questionId")
    @Mapping(source = "user.nickname", target = "nickname")
    AnswerResponseDto answerResponseDto(Answer answer);

    List<AnswerResponseDto> answerToAnswerDtos(List<Answer> answers);

}
