package com.hexacoder.stackoverflow.question.mapper;

import com.hexacoder.stackoverflow.Answer.AnswerDto.AnswerResponseDto;
import com.hexacoder.stackoverflow.question.dto.AllQuestionDto;
import com.hexacoder.stackoverflow.question.dto.AskQuestionDto;
import com.hexacoder.stackoverflow.question.dto.QuestionDetailDto;
import com.hexacoder.stackoverflow.question.dto.QuestionPatchDto;
import com.hexacoder.stackoverflow.question.dto.ResponseDto;
import com.hexacoder.stackoverflow.question.entity.Question;
import com.hexacoder.stackoverflow.question.entity.QuestionTag;
import com.hexacoder.stackoverflow.tag.entity.Tag;
import java.time.format.DateTimeFormatter;
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
        List<Tag> questionTag = null;

        QuestionDetailDto questionDetailDto = new QuestionDetailDto( questionId, title, content, userId, nickname, answerList, createdAt, questionTag );

        return questionDetailDto;
    }

    @Override
    public List<ResponseDto> questionsToResponse(List<Question> questions) {
        if ( questions == null ) {
            return null;
        }

        List<ResponseDto> list = new ArrayList<ResponseDto>( questions.size() );
        for ( Question question : questions ) {
            list.add( questionToResponseDto( question ) );
        }

        return list;
    }

    protected ResponseDto questionToResponseDto(Question question) {
        if ( question == null ) {
            return null;
        }

        List<QuestionTag> questionTags = null;

        List<QuestionTag> list = question.getQuestionTags();
        if ( list != null ) {
            questionTags = new ArrayList<QuestionTag>( list );
        }

        ResponseDto responseDto = new ResponseDto( questionTags );

        return responseDto;
    }
}
