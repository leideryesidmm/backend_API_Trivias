package com.gamegenius.trivia.persistence.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "idAuth",unique = true)
    private String idAuth;
    private String user;
    private String nickname;
    private String email;
    private Date birthdate;
    private long bombicoins;
    private long bombicoinsObtenidas;
    private int maxScoreGK;

}
