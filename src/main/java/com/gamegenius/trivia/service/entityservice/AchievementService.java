package com.gamegenius.trivia.service.entityservice;

import com.gamegenius.trivia.mapper.AchievementInDtoToArchievement;
import com.gamegenius.trivia.persistence.entity.Achievement;
import com.gamegenius.trivia.persistence.repository.AchievementRepository;
import com.gamegenius.trivia.service.dto.AchievementInDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AchievementService {
    private final AchievementRepository repository;
    private final AchievementInDtoToArchievement mapper;

    public AchievementService(AchievementRepository repository, AchievementInDtoToArchievement mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Achievement createAchievement(AchievementInDto achievementInDto){
        Achievement achievement = mapper.map(achievementInDto);
        achievement=this.repository.save(achievement);
        return achievement;
    }
    public AchievementInDto getAchievement(long id){
        Achievement achievement =this.repository.getById(id);
        AchievementInDto achievementInDto=this.mapper.map2(achievement);
        return achievementInDto;
    }
    public List<AchievementInDto> getAllAchievement(){
        List<Achievement> achievements =this.repository.findAll();
        List<AchievementInDto> achievementInDtos = new ArrayList<>();
        for (Achievement achievement:achievements) {
            AchievementInDto achievementInDto=this.mapper.map2(achievement);
            achievementInDtos.add(achievementInDto);
        }
        return achievementInDtos;
    }
}
