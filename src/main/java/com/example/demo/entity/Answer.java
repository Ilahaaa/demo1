package com.example.demo.entity;

import javax.persistence.*;


@Entity
@Table(name = "answer")
public class Answer implements  java.io.Serializable {
    private static final long serialVersionUID = 1l;

    private Integer id;
    private String context;
    private Question question;
    private Boolean correct;

    public Answer() {
    }

    public Answer(String context, Question question, Boolean correct) {
        this.context = context;
        this.question = question;
        this.correct = correct;
    }
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id",unique = true,nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
     @Column(name = "context")
    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
    @Column(name = "correct")
    public Boolean getCorrect() {
        return correct;
    }

    public void setCorrect(Boolean correct) {
        this.correct = correct;
    }
}
