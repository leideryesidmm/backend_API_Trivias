package com.gamegenius.trivia.service.entityservice;

import com.gamegenius.trivia.mapper.UserAchievementInDtoToUserAchievement;
import com.gamegenius.trivia.persistence.entity.UserAchievement;
import com.gamegenius.trivia.persistence.repository.UserAchievementRepository;
import com.gamegenius.trivia.service.dto.UserAchievementInDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserAchievementService {
    private final UserAchievementRepository repository;
    private final UserAchievementInDtoToUserAchievement mapper;

    public UserAchievementService(UserAchievementRepository repository, UserAchievementInDtoToUserAchievement mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public UserAchievement createUserAchievement(UserAchievementInDto userAchievementInDto){
        UserAchievement userAchievement = mapper.map(userAchievementInDto);
        userAchievement=this.repository.save(userAchievement);
        return userAchievement;
    }
    public UserAchievementInDto getUserAchievement(long id){
        UserAchievement userAchievement =this.repository.getById(id);
        UserAchievementInDto userAchievementInDto=this.mapper.map2(userAchievement);
        return userAchievementInDto;
    }
    public List<UserAchievementInDto> getAllUserAchievement(){
        List<UserAchievement> userAchievements =this.repository.findAll();
        List<UserAchievementInDto> userAchievementInDtos = new ArrayList<>();
        for (UserAchievement userAchievement:userAchievements) {
            UserAchievementInDto userAchievementInDto=this.mapper.map2(userAchievement);
            userAchievementInDtos.add(userAchievementInDto);
        }
        return userAchievementInDtos;
    }
}
