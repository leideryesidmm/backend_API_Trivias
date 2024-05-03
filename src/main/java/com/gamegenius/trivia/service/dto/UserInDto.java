package com.gamegenius.trivia.service.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class UserInDto {
    private long idUser;
    private String idAuth;
    private String user;
    private String nickname;
    private String email;
    private Date birthdate;
    private long bombicoins;
    private long bombicoinsObtenidas;
    private int maximumstreak;
}
