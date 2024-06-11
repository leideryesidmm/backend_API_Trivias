package com.gamegenius.trivia.mapper;

import com.gamegenius.trivia.persistence.entity.Score;
import com.gamegenius.trivia.service.dto.ScoreInDto;
import org.springframework.stereotype.Component;

@Component
public class ScoreInDtoToScore implements IMapper<ScoreInDto, Score> {
    private final SubCategoryInDtoToSubCategory mapperSubCategory;
    private final UserInDtoToUser mapperUser;

    public ScoreInDtoToScore(SubCategoryInDtoToSubCategory mapperSubCategory, UserInDtoToUser mapperUser) {
        this.mapperSubCategory = mapperSubCategory;
        this.mapperUser = mapperUser;
    }

    @Override
    public Score map(ScoreInDto in) {
        System.out.println(in);
        Score score = new Score();
        score.setIdScore(in.getIdScore());
        score.setMaxScore(in.getMaxScore());
        if (in.getSubCategory() != null)
            score.setSubCategory(this.mapperSubCategory.map(in.getSubCategory()));
        if (in.getUser() != null)
            score.setUser(this.mapperUser.map(in.getUser()));
        return score;
    }

    @Override
    public ScoreInDto map2(Score in) {
        System.out.println(in);
        ScoreInDto scoreInDto = new ScoreInDto();
        scoreInDto.setIdScore(in.getIdScore());
        scoreInDto.setMaxScore(in.getMaxScore());
        if (in.getSubCategory() != null)
            scoreInDto.setSubCategory(this.mapperSubCategory.map2(in.getSubCategory()));
        if (in.getUser() != null)
            scoreInDto.setUser(this.mapperUser.map2(in.getUser()));
        return scoreInDto;
    }
}