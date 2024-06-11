package com.gamegenius.trivia.service.entityservice;

import com.gamegenius.trivia.mapper.ScoreInDtoToScore;
import com.gamegenius.trivia.persistence.entity.Score;
import com.gamegenius.trivia.persistence.entity.SubCategory;
import com.gamegenius.trivia.persistence.repository.ScoreRepository;
import com.gamegenius.trivia.service.dto.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScoreService {
    private final ScoreRepository repository;
    private final ScoreInDtoToScore mapper;
    private final SubCategoryService subCategoryService;

    public ScoreService(ScoreRepository repository, ScoreInDtoToScore mapper, SubCategoryService subCategoryService) {
        this.repository = repository;
        this.mapper = mapper;
        this.subCategoryService = subCategoryService;
    }

    public ScoreInDto createScore(ScoreInDto scoreInDto){
        System.out.println(scoreInDto);
        Score score = mapper.map(scoreInDto);
        score=this.repository.save(score);
        scoreInDto=this.mapper.map2(score);
        return scoreInDto;
    }

    public ScoreInDto getScore(long id){
        Score score =this.repository.getById(id);
        ScoreInDto scoreInDto=this.mapper.map2(score);
        return scoreInDto;
    }
    public ScoreInDto getScoreByUserAndSubCategory(long idUser,long idSubCategory){
        Score score =this.repository.getScoreByUserAndSubCategory(idUser,idSubCategory);
        ScoreInDto scoreInDto=this.mapper.map2(score);
        return scoreInDto;
    }
    @Transactional
    public void setMaxScore(long id,long maxScore){
        try{
        this.repository.setMaxScore(id,maxScore);
        }catch (Exception e){
        System.out.println(e.getMessage());
        }
    }
    @Transactional
    public void newMaxScore(long idUser,long subCategory, long maxScore){
        try{
            ScoreInDto scoreInDto=getScoreByUserAndSubCategory(idUser,subCategory);
            if(scoreInDto.getMaxScore()<maxScore)
            setMaxScore(scoreInDto.getIdScore(),maxScore);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public List<ScoreInDto> initializeScores(UserInDto userInDto){
        try {
            List<SubCategoryInDto> subCategoryInDtos = this.subCategoryService.getAllSubCategorys();
            List<ScoreInDto> scores = new ArrayList<>();
            for (SubCategoryInDto subCategoryInDto : subCategoryInDtos) {
                ScoreInDto scoreInDto = new ScoreInDto();
                scoreInDto.setSubCategory(subCategoryInDto);
                scoreInDto.setUser(userInDto);
                System.out.println(scoreInDto);
                scores.add(createScore(scoreInDto));
            }
            return scores;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
