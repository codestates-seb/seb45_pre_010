//package com.hexacoder.stackoverflow.question.entity;
//
//import com.hexacoder.stackoverflow.question.audit.Auditable;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import org.springframework.data.annotation.Id;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//
//@NoArgsConstructor
//@Getter
//@Setter
//@Entity
//public class QuestionTag extends Auditable {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long questionTagId;
//
//    @ManyToOne
//    @JoinColumn(name = "question_id")
//    private Question question;
//
////    @ManyToOne
////    @JoinColumn(name = "tag_id")
////    private Tag tag;
//
////    public QuestionTag(Question question, Tag tag) {
////        this.question = question;
////        this.tag = tag;
////    }
//
//    public void addQuestion(Question question) {
//        this.question = question;
//    }
//
//    public void addTag(Tag tag) {
//        this.tag = tag;
//    }
//}
