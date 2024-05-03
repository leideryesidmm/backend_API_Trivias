package com.gamegenius.trivia.persistence.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="typequestion")
public class TypeQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTypeQuestion;
    private String name;
    private String description;
}
