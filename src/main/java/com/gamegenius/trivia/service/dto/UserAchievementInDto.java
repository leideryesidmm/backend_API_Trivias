package com.gamegenius.trivia.service.dto;

import com.gamegenius.trivia.persistence.entity.Achievement;
import com.gamegenius.trivia.persistence.entity.User;
import lombok.Data;

import java.time.LocalDate;
@Data
public class UserAchievementInDto {
    private long idUserAchievement;
    private UserInDto user;
    private AchievementInDto achievement;
    private LocalDate date;
}
