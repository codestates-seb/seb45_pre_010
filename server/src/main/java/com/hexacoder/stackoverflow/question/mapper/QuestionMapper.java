package com.hexacoder.stackoverflow.question.mapper;

import com.hexacoder.stackoverflow.Answer.AnswerDto.AnswerResponseDto;
import com.hexacoder.stackoverflow.question.dto.*;
import com.hexacoder.stackoverflow.question.entity.Question;
import com.hexacoder.stackoverflow.question.repository.QuestionRepository;
import com.hexacoder.stackoverflow.user.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.Mapping;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface QuestionMapper {


    Question askquestionPostToQuestion(AskQuestionDto.Post requestBody);

    AllQuestionDto questionToAllQuestion(Question question);


    Question questionUpdateDtoToQuestion(QuestionPatchDto questionUpdateDto);



    default TopQuestionDto.Response questionToTopQuestion(
            QuestionUserProfileDto questionUserProfileDto) {
        if (questionUserProfileDto == null) {
            return null;
        } else {
            long questionId = 0;
            String title = null;
            int count = 0;
            String nickname = null;
            String createdAt = null;

            questionId = questionUserProfileDto.getQuestion().getQuestionId();
            title = questionUserProfileDto.getQuestion().getTitle();
            count = questionUserProfileDto.getAnswerList().size();
            nickname = questionUserProfileDto.getUser().getNickname();
            //createdAt = questionUserProfileDto.getQuestion().getCreatedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            createdAt = questionUserProfileDto.getQuestion().getCreatedAt() != null ?
                    questionUserProfileDto.getQuestion().getCreatedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) : null;


            TopQuestionDto.Response topQuestionDto = new TopQuestionDto.Response(questionId, title, count, nickname, createdAt);
            return topQuestionDto;
        }
    }


    //질문 상세
    QuestionDetailDto questionToQuestionDetail(Question question);

    default QuestionDetailDto questionToResponse(
            QuestionUserProfileDto questionUserProfileDto) {
        if (questionUserProfileDto == null) {
            return null;
        } else {
            long questionId = 0;
            String title = null;
            String content = null;
            long userId = 0;
            String nickname = null;
            List<AnswerResponseDto> answerList = new ArrayList<>();
            String createdAt = null;

            LocalDateTime questionCreatedAt = questionUserProfileDto.getQuestion().getCreatedAt();
            if (questionCreatedAt != null) {
                createdAt = questionCreatedAt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            }


            questionId = questionUserProfileDto.getQuestion().getQuestionId();
            title = questionUserProfileDto.getQuestion().getTitle();
            content = questionUserProfileDto.getQuestion().getContent();
            userId = questionUserProfileDto.getUser().getUserId();
            nickname = questionUserProfileDto.getUser().getNickname();


            questionUserProfileDto.getAnswerList().stream()
                    .forEach(answer -> {
                        UserEntity answerUser = answer.getUser();

                        AnswerResponseDto answerResponse = new AnswerResponseDto();

                        answerResponse.setUserId(answerUser.getUserId());
                        answerResponse.setAnswerId(answer.getAnswerId());
                        answerResponse.setContent(answer.getContent());
                        answerResponse.setNickname(answerResponse.getNickname());
                        answerResponse.setCreatedAt(answer.getCreatedAt());
                        answerList.add(answerResponse);
                    });

//            createdAt = questionUserProfileDto.getQuestion().getCreatedAt().format(
//                    DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            createdAt = questionUserProfileDto.getQuestion().getCreatedAt() != null ?
                    questionUserProfileDto.getQuestion().getCreatedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) : null;


            QuestionDetailDto questionDetailDto =
                    new QuestionDetailDto(questionId, title, content, userId, nickname, answerList, createdAt);
            return questionDetailDto;
        }
    }

    default AllQuestionDto AllQuestionResponseDto(Question question) {

        AllQuestionDto allQuestionDto = new AllQuestionDto();
        allQuestionDto.setQuestionId(question.getQuestionId());
        allQuestionDto.setTitle(question.getTitle());
        allQuestionDto.setContent(question.getContent());
        allQuestionDto.setAnswerCount(question.getAnswers().stream().count());

        LocalDateTime createdAt = question.getCreatedAt();
        allQuestionDto.setCreatedAt(createdAt != null ?
                createdAt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) : null);



        allQuestionDto.setUser(question.getUser());
        allQuestionDto.setNickname(question.getUser().getNickname());
        //allQuestionDto.setCreatedAt(question.getCreatedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

        return allQuestionDto;
    }



}