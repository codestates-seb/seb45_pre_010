package com.hexacoder.stackoverflow.question.entity;

import com.hexacoder.stackoverflow.question.audit.Auditable;
import com.hexacoder.stackoverflow.tag.entity.Tag;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class QuestionTag extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionTagId;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    @ManyToOne
    @JoinColumn(name = "tag_id")
    private Tag tag;

    public QuestionTag(Question question, Tag tag) {
        this.question = question;
        this.tag = tag;
    }

    public void addQuestion(Question question) {
        this.question = question;
    }

    public void addTag(Tag tag) {
        this.tag = tag;
    }
}
