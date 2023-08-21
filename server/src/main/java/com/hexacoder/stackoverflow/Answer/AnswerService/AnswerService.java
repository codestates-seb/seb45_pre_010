package com.hexacoder.stackoverflow.Answer.AnswerService;

import com.hexacoder.stackoverflow.Answer.AnswerEntity.Answer;
import com.hexacoder.stackoverflow.Answer.AnswerRepository.AnswerRepository;
import com.hexacoder.stackoverflow.question.entity.Question;
import com.hexacoder.stackoverflow.question.service.QuestionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
    public class AnswerService {
    private final AnswerRepository answerRepository;
    private final QuestionService questionService;

    public AnswerService(AnswerRepository answerRepository, QuestionService questionService) {
        this.answerRepository = answerRepository;
        this.questionService = questionService;
    }

    public List<Answer> createAnswer(Answer answer, Long questionId) {
        Question question = questionService.findQuestion(questionId);

        answer.addQuestion(question);
        answerRepository.save(answer);

        return answerRepository.findByQuestionId(question.getQuestionId());
    }

    public Answer updateAnswer(long answerId, String updatedContent, long questionId) {
        Question question = questionService.findQuestion(questionId);
        Answer findAnswer = findAnswerById(answerId);

        findAnswer.setContent(updatedContent);
        answerRepository.save(findAnswer);
        return findAnswer;
    }

    public List<Answer> getAnswer(long questionId) {
        // 로그를 추가하여 메서드 호출 및 조회된 데이터 확인
        System.out.println("Calling getAnswer with questionId: " + questionId);

        List<Answer> answers = answerRepository.findByQuestionId(questionId);

        // 조회된 데이터 확인을 위한 로그 출력
        System.out.println("Found " + answers.size() + " answers for questionId: " + questionId);
        for (Answer answer : answers) {
            System.out.println("Answer: " + answer);
        }

        return answers;
    }

    public List<Answer> deleteAnswer(long answerId) {
        Answer answer = findAnswerById(answerId);

        answerRepository.deleteById(answer.getAnswerId());
        return answerRepository.findByQuestionId(answer.getQuestion().getQuestionId());
    }


    public Answer findAnswerById(long answerId) {
        return answerRepository.findById(answerId).orElse(null);
    }
}