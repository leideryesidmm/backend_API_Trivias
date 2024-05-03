package com.gamegenius.trivia.persistence.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="achievement")
public class Achievement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idAchievement;
    private String name;
    private String description;

}
