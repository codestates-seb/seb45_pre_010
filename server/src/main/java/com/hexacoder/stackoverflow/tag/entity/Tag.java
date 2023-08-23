package com.hexacoder.stackoverflow.tag.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hexacoder.stackoverflow.question.entity.QuestionTag;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor
@Setter
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tag_id")
    private Long tagId;

    @Column(nullable = false, unique = true)
    private String tagName;



    @OneToMany(mappedBy = "tag", fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
    @JsonIgnore
    private List<QuestionTag> questionTags = new ArrayList<>();

    public Tag(String tagName) {
        this.tagName = tagName;

    }

    public void addQuestionTag(QuestionTag questionTag) {
        this.questionTags.add(questionTag);
    }
}
