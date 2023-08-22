package com.hexacoder.stackoverflow.question.mapper;

import com.hexacoder.stackoverflow.Answer.AnswerDto.AnswerResponseDto;
import com.hexacoder.stackoverflow.question.dto.*;
import com.hexacoder.stackoverflow.question.entity.Question;
import com.hexacoder.stackoverflow.question.entity.QuestionTag;
import com.hexacoder.stackoverflow.question.repository.QuestionRepository;
import com.hexacoder.stackoverflow.tag.entity.Tag;
import com.hexacoder.stackoverflow.user.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.Mapping;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
            List<Tag> questionTag = null;

            questionId = questionUserProfileDto.getQuestion().getQuestionId();
            title = questionUserProfileDto.getQuestion().getTitle();
            count = questionUserProfileDto.getAnswerList().size();
            nickname = questionUserProfileDto.getUser().getNickname();
            questionTag = questionUserProfileDto.getTagList();
            createdAt = questionUserProfileDto.getQuestion().getCreatedAt() != null ?
                    questionUserProfileDto.getQuestion().getCreatedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) : null;


            TopQuestionDto.Response topQuestionDto = new TopQuestionDto.Response(questionId, title, count, nickname, createdAt, questionTag);
            return topQuestionDto;
        }
    }


    //질문 상세
    QuestionDetailDto questionToQuestionDetail(Question question);

    default QuestionDetailDto questionToResponse(QuestionUserProfileDto questionUserProfileDto) {
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
            List<Tag> questionTag = null;

            LocalDateTime questionCreatedAt = questionUserProfileDto.getQuestion().getCreatedAt();
            if (questionCreatedAt != null) {
                createdAt = questionCreatedAt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            }

            questionId = questionUserProfileDto.getQuestion().getQuestionId();
            title = questionUserProfileDto.getQuestion().getTitle();
            content = questionUserProfileDto.getQuestion().getContent();
            userId = questionUserProfileDto.getUser().getUserId();
            nickname = questionUserProfileDto.getUser().getNickname();
            questionTag = questionUserProfileDto.getTagList();

            questionUserProfileDto.getAnswerList().forEach(answer -> {
                UserEntity answerUser = answer.getUser();

                AnswerResponseDto answerResponse = new AnswerResponseDto();
                answerResponse.setUserId(answerUser.getUserId());
                answerResponse.setAnswerId(answer.getAnswerId());
                answerResponse.setContent(answer.getContent());
                answerResponse.setNickname(answerUser.getNickname());  // Fix this line
                answerResponse.setCreatedAt(answer.getCreatedAt());
                answerList.add(answerResponse);
            });

            createdAt = questionUserProfileDto.getQuestion().getCreatedAt() != null ?
                    questionUserProfileDto.getQuestion().getCreatedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) : null;

            // 중복 태그 제거
            Set<Tag> uniqueTags = new HashSet<>(questionTag);
            List<Tag> distinctTags = new ArrayList<>(uniqueTags);

            QuestionDetailDto questionDetailDto = new QuestionDetailDto(
                    questionId, title, content, userId, nickname, answerList, createdAt, distinctTags);

            return questionDetailDto;
        }
    }




    default AllQuestionDto AllQuestionResponseDto(Question question) {

        List<QuestionTag> questionTags = question.getQuestionTags();


        AllQuestionDto allQuestionDto = new AllQuestionDto();
        allQuestionDto.setQuestionId(question.getQuestionId());
        allQuestionDto.setTitle(question.getTitle());
        allQuestionDto.setContent(question.getContent());
        allQuestionDto.setAnswerCount(question.getAnswers().stream().count());
        allQuestionDto.setQuestionTag(questionTagsToQuestionTagResponseDto(questionTags));

        LocalDateTime createdAt = question.getCreatedAt();
        allQuestionDto.setCreatedAt(createdAt != null ?
                createdAt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) : null);



        allQuestionDto.setUser(question.getUser());
        allQuestionDto.setNickname(question.getUser().getNickname());

        return allQuestionDto;
    }


    default List<QuestionTagResponseDto> questionTagsToQuestionTagResponseDto(List<QuestionTag> questionTags) {
        return questionTags
                .stream()
                .map(questionTag -> QuestionTagResponseDto
                        .builder()
                        .tagId(questionTag.getTag().getTagId())
                        .tagName(questionTag.getTag().getTagName())
                        .build())
                .collect(Collectors.toList());
    }

    List<ResponseDto> questionsToResponse(List<Question> questions);


}