package com.hexacoder.stackoverflow.question.mapper;

import com.hexacoder.stackoverflow.Answer.AnswerDto.AnswerResponseDto;
import com.hexacoder.stackoverflow.question.dto.AllQuestionDto;
import com.hexacoder.stackoverflow.question.dto.AskQuestionDto;
import com.hexacoder.stackoverflow.question.dto.QuestionDetailDto;
import com.hexacoder.stackoverflow.question.dto.QuestionPatchDto;
import com.hexacoder.stackoverflow.question.entity.Question;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-18T18:25:54+0900",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.2.1.jar, environment: Java 17.0.8 (IBM Corporation)"
)
@Component
public class QuestionMapperImpl implements QuestionMapper {

    @Override
    public Question askquestionPostToQuestion(AskQuestionDto.Post requestBody) {
        if ( requestBody == null ) {
            return null;
        }

        Question question = new Question();

        question.setTitle( requestBody.getTitle() );
        question.setContent( requestBody.getContent() );

        return question;
    }

    @Override
    public AllQuestionDto questionToAllQuestion(Question question) {
        if ( question == null ) {
            return null;
        }

        AllQuestionDto allQuestionDto = new AllQuestionDto();

        allQuestionDto.setUser( question.getUser() );
        allQuestionDto.setQuestionId( question.getQuestionId() );
        allQuestionDto.setTitle( question.getTitle() );
        allQuestionDto.setContent( question.getContent() );
        if ( question.getCreatedAt() != null ) {
            allQuestionDto.setCreatedAt( DateTimeFormatter.ISO_LOCAL_DATE_TIME.format( question.getCreatedAt() ) );
        }

        return allQuestionDto;
    }

    @Override
    public Question questionUpdateDtoToQuestion(QuestionPatchDto questionUpdateDto) {
        if ( questionUpdateDto == null ) {
            return null;
        }

        Question question = new Question();

        question.setQuestionId( questionUpdateDto.getQuestionId() );
        question.setTitle( questionUpdateDto.getTitle() );
        question.setContent( questionUpdateDto.getContent() );

        return question;
    }

    @Override
    public QuestionDetailDto questionToQuestionDetail(Question question) {
        if ( question == null ) {
            return null;
        }

        long questionId = 0L;
        String title = null;
        String content = null;
        String createdAt = null;

        questionId = question.getQuestionId();
        title = question.getTitle();
        content = question.getContent();
        if ( question.getCreatedAt() != null ) {
            createdAt = DateTimeFormatter.ISO_LOCAL_DATE_TIME.format( question.getCreatedAt() );
        }

        long userId = 0L;
        String nickname = null;
        List<AnswerResponseDto> answerList = null;

        QuestionDetailDto questionDetailDto = new QuestionDetailDto( questionId, title, content, userId, nickname, answerList, createdAt );

        return questionDetailDto;
    }
}
