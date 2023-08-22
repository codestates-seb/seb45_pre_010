package com.hexacoder.stackoverflow.question.repository;

import com.hexacoder.stackoverflow.question.entity.Question;
import com.hexacoder.stackoverflow.question.entity.QuestionTag;
import com.hexacoder.stackoverflow.tag.entity.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionTagRepository extends JpaRepository<QuestionTag, Long> {
    @Query("SELECT qt.tag FROM QuestionTag qt WHERE qt.question.questionId = :questionId")
    List<Tag> findTagsByQuestionId(@Param("questionId") Long questionId);

    @Query("SELECT qt.question FROM QuestionTag qt WHERE qt.tag.tagId = :tagId")
    Page<Question> findQuestionsByTagId(Long tagId, Pageable pageable);
}