package com.gamegenius.trivia.persistence.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="wildcard")
public class Wildcard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idWildcard;
    private String name;
    private String description;
    private int cost;
    private String icon;
}
