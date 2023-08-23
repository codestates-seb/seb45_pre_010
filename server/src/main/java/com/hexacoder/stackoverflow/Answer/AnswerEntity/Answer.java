package com.hexacoder.stackoverflow.Answer.AnswerEntity;

import com.hexacoder.stackoverflow.question.audit.Auditable;
import com.hexacoder.stackoverflow.question.entity.Question;
import com.hexacoder.stackoverflow.user.entity.UserEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Answer extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long answerId;

    @Column(nullable = false)
    private String content;

    @CreatedDate
    @Column(nullable = false)
    public LocalDateTime createdAt = LocalDateTime.now();


    //private Question Question;

    public Answer(String content){
        this.content = content;
    }

    //user 정보 연관 관계 매핑
    @ManyToOne
    @JoinColumn(name = "QUESTION_ID")
    private Question question;

    public void addQuestion(Question question){
        this.question = question;
    }

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private UserEntity user;
    public Answer(Question question, String content, UserEntity user) {
        this.question = question;
        this.content = content;
        this.user = user;
    }

    public void addUser(UserEntity user) {
        this.user = user;
    }



}
