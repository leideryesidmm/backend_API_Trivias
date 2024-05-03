package com.gamegenius.trivia.mapper;

import com.gamegenius.trivia.persistence.entity.UserAchievement;
import com.gamegenius.trivia.service.dto.UserAchievementInDto;
import org.springframework.stereotype.Component;

@Component
public class UserAchievementInDtoToUserAchievement implements IMapper<UserAchievementInDto, UserAchievement>{
    private final UserInDtoToUser mapperUser;
    private final AchievementInDtoToArchievement mapperAchievement;

    public UserAchievementInDtoToUserAchievement(UserInDtoToUser mapperUser, AchievementInDtoToArchievement mapperAchievement) {
        this.mapperUser = mapperUser;
        this.mapperAchievement = mapperAchievement;
    }

    @Override
    public UserAchievement map(UserAchievementInDto in) {
        UserAchievement userAchievement = new UserAchievement();
        userAchievement.setIdUserAchievement(in.getIdUserAchievement());
        if(in.getAchievement()!=null)
        userAchievement.setAchievement(this.mapperAchievement.map(in.getAchievement()));
        if(in.getUser()!=null)
        userAchievement.setUser(this.mapperUser.map(in.getUser()));
        userAchievement.setDate(in.getDate());
        return userAchievement;
    }
    @Override
    public UserAchievementInDto map2(UserAchievement in) {
        UserAchievementInDto userAchievementInDto = new UserAchievementInDto();
        userAchievementInDto.setIdUserAchievement(in.getIdUserAchievement());
        if(in.getAchievement()!=null)
            userAchievementInDto.setAchievement(this.mapperAchievement.map2(in.getAchievement()));
        if(in.getUser()!=null)
            userAchievementInDto.setUser(this.mapperUser.map2(in.getUser()));
        userAchievementInDto.setDate(in.getDate());
        return userAchievementInDto;
    }
}