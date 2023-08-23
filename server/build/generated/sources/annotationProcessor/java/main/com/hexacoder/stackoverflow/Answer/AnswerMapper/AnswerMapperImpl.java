package com.hexacoder.stackoverflow.Answer.AnswerMapper;

import com.hexacoder.stackoverflow.Answer.AnswerDto.AnswerPatchDto;
import com.hexacoder.stackoverflow.Answer.AnswerDto.AnswerPostDto;
import com.hexacoder.stackoverflow.Answer.AnswerDto.AnswerResponseDto;
import com.hexacoder.stackoverflow.Answer.AnswerEntity.Answer;
import com.hexacoder.stackoverflow.question.entity.Question;
import com.hexacoder.stackoverflow.user.entity.UserEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-21T18:00:20+0900",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.2.1.jar, environment: Java 19.0.2 (Oracle Corporation)"
)
@Component
public class AnswerMapperImpl implements AnswerMapper {

    @Override
    public Answer answerPostDtoToAnswer(AnswerPostDto answerPostDto) {
        if ( answerPostDto == null ) {
            return null;
        }

        Answer answer = new Answer();

        answer.setContent( answerPostDto.getContent() );

        return answer;
    }

    @Override
    public Answer answerPatchDtoToAnswer(AnswerPatchDto answerPatchDto) {
        if ( answerPatchDto == null ) {
            return null;
        }

        Answer answer = new Answer();

        answer.setAnswerId( answerPatchDto.getAnswerId() );
        answer.setContent( answerPatchDto.getContent() );

        return answer;
    }

    @Override
    public AnswerResponseDto answerResponseDto(Answer answer) {
        if ( answer == null ) {
            return null;
        }

        AnswerResponseDto answerResponseDto = new AnswerResponseDto();

        answerResponseDto.setUserId( answerUserUserId( answer ) );
        answerResponseDto.setQuestionId( answerQuestionQuestionId( answer ) );
        answerResponseDto.setNickname( answerUserNickname( answer ) );
        answerResponseDto.setUser( answer.getUser() );
        answerResponseDto.setQuestion( answer.getQuestion() );
        answerResponseDto.setAnswerId( answer.getAnswerId() );
        answerResponseDto.setContent( answer.getContent() );
        answerResponseDto.setCreatedAt( answer.getCreatedAt() );

        return answerResponseDto;
    }

    @Override
    public List<AnswerResponseDto> answerToAnswerDtos(List<Answer> answers) {
        if ( answers == null ) {
            return null;
        }

        List<AnswerResponseDto> list = new ArrayList<AnswerResponseDto>( answers.size() );
        for ( Answer answer : answers ) {
            list.add( answerResponseDto( answer ) );
        }

        return list;
    }

    private Long answerUserUserId(Answer answer) {
        if ( answer == null ) {
            return null;
        }
        UserEntity user = answer.getUser();
        if ( user == null ) {
            return null;
        }
        Long userId = user.getUserId();
        if ( userId == null ) {
            return null;
        }
        return userId;
    }

    private Long answerQuestionQuestionId(Answer answer) {
        if ( answer == null ) {
            return null;
        }
        Question question = answer.getQuestion();
        if ( question == null ) {
            return null;
        }
        long questionId = question.getQuestionId();
        return questionId;
    }

    private String answerUserNickname(Answer answer) {
        if ( answer == null ) {
            return null;
        }
        UserEntity user = answer.getUser();
        if ( user == null ) {
            return null;
        }
        String nickname = user.getNickname();
        if ( nickname == null ) {
            return null;
        }
        return nickname;
    }
}
