package com.hexacoder.stackoverflow.question.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hexacoder.stackoverflow.Answer.AnswerEntity.Answer;
import com.hexacoder.stackoverflow.question.audit.Auditable;
import com.hexacoder.stackoverflow.tag.entity.Tag;
import com.hexacoder.stackoverflow.user.entity.UserEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Question extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    private long questionId;

    @Column(name = "title", nullable = false)
    private String title;


    @Column(name = "content", nullable = false)
    private String content;

    @Enumerated(EnumType.STRING)
    private QuestionStatus questionStatus = QuestionStatus.QUESTION_ING;

    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JsonIgnore
    private List<Answer> answers = new ArrayList<>();

    @Column(nullable = false, name = "LAST_MODIFIED_AT")
    private LocalDateTime modifiedAt = LocalDateTime.now();

    @Column(nullable = false, name = "CREATED_AT")
    private LocalDateTime createdAt = LocalDateTime.now();

    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JsonIgnore
    private List<QuestionTag> questionTags = new ArrayList<>();


    public Question(String title, String content) {
        this.title = title;
        this.content = content;
        this.createdAt = LocalDateTime.now();
    }

    public void addQuestionTags(List<Tag> tags) {
        List<QuestionTag> questionTags = tags.stream()
                .map((tag) -> new QuestionTag(this, tag))
                .collect(Collectors.toList());

        for (QuestionTag questionTag : questionTags) {
            addQuestionTag(questionTag);
        }

    }

    public void addQuestionTag(QuestionTag questionTag) {
        questionTags.add(questionTag);
    }





    public enum QuestionStatus {
        QUESTION_ING(1, "질문중"),
        QUESTION_COMPLETE(2, "답변 완료"),
        QUESTION_CANCEL(3, "질문 삭제");


        @Getter
        private int stepNumber;

        @Getter
        private String stepDescription;

        QuestionStatus(int stepNumber, String stepDescription) {
            this.stepNumber = stepNumber;
            this.stepDescription = stepDescription;
        }
    }

       // User 정보 연관 관계 매핑
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private UserEntity user;

    public void addUser(UserEntity user) {
        this.user = user;
    }
}

