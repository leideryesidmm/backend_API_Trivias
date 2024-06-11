package com.gamegenius.trivia.service.dto;

import com.gamegenius.trivia.persistence.entity.SubCategory;
import com.gamegenius.trivia.persistence.entity.User;
import lombok.Data;


@Data
public class ScoreInDto {
    private long idScore;
    private UserInDto user;
    private SubCategoryInDto subCategory;
    private long maxScore;
}
