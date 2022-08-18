package com.example.demo.entity;



import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "question")
public class Question implements  java.io.Serializable {
private static final long serialVersionUID=1l;

private Integer id;
private String context;
private Set<Answer> answers=  new HashSet<Answer>(0);

    public Question() {
    }

    public Question(String context) {
        this.context = context;
    }

    public Question(String context, Set<Answer> answers) {
        this.context = context;
        this.answers = answers;
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
    @OneToMany(fetch = FetchType.LAZY , mappedBy = "question")
    public Set<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(Set<Answer> answers) {
        this.answers = answers;
    }
}
