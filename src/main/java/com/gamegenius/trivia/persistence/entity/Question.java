package com.gamegenius.trivia.persistence.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="question")
@Inheritance(strategy = InheritanceType.JOINED)
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idQuestion;
    @ManyToOne
    @JoinColumn(name = "subCategory")
    private SubCategory subCategory;
    String description;
    private int time;
    @ManyToOne
    @JoinColumn(name="typeQuestion")
    private TypeQuestion typeQuestion;
}
