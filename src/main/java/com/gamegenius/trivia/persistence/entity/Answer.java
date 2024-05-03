package com.gamegenius.trivia.persistence.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="answer")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idAnswer;

    @ManyToOne
    @JoinColumn(name="question")
    private Question question;
    private String description;
    private boolean correct;
}
