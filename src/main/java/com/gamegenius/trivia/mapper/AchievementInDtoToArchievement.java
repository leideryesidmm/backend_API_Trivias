package com.gamegenius.trivia.mapper;

import com.gamegenius.trivia.persistence.entity.Achievement;
import com.gamegenius.trivia.service.dto.AchievementInDto;
import org.springframework.stereotype.Component;

@Component
public class AchievementInDtoToArchievement implements IMapper<AchievementInDto, Achievement>{
    @Override
    public Achievement map(AchievementInDto in) {
        Achievement achievement = new Achievement();
        achievement.setIdAchievement(in.getIdAchievement());
        achievement.setName(in.getName());
        achievement.setDescription(in.getDescription());
        return achievement;
    }
    @Override
    public AchievementInDto map2(Achievement in) {
        AchievementInDto achievementInDto = new AchievementInDto();
        achievementInDto.setIdAchievement(in.getIdAchievement());
        achievementInDto.setName(in.getName());
        achievementInDto.setDescription(in.getDescription());
        return achievementInDto;
    }
}
