
package com.agolumbowski.spring.rest.quiz_rest.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.persistence.Table;

/**
 *
 * @author agolu
 */
@Entity
@Table(name = "questions")
public class Question implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    private String description;
    @ManyToOne(fetch = FetchType.EAGER)
    private Quiz quiz;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE, mappedBy="question")
    @OrderBy("id")
    private List <Answer> answers;

    public Question() {
    }

    public Question(String description, Quiz quiz, List<Answer> answers) {
        this.description = description;
        this.quiz = quiz;
        this.answers = answers;
    }
    

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the answers
     */
    public List <Answer> getAnswers() {
        return answers;
    }

    /**
     * @param answers the answers to set
     */
    public void setAnswers(List <Answer> answers) {
        this.answers = answers;
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    public Quiz getTest() {
        return quiz;
    }

    public void setTest(Quiz test) {
        this.quiz = test;
    }

    @Override
    public String toString() {
        return "Question{" + "id=" + id + ", description=" + description + ", quiz="+ ", answers=" + answers + '}';
    }
    
}
