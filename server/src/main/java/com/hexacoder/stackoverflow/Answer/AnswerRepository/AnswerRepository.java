package com.hexacoder.stackoverflow.Answer.AnswerRepository;

import com.hexacoder.stackoverflow.Answer.AnswerEntity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer, Long> {

    @Query(value = "SELECT * FROM answer WHERE question_id = :questionId", nativeQuery = true)
    List<Answer> findByQuestionId(long questionId);
    // 답변 생성 메서드 추가
    Answer save(Answer answer);
}
