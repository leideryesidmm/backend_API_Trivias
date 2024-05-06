package com.gamegenius.trivia.service.dto;

import com.gamegenius.trivia.persistence.entity.Answer;
import com.gamegenius.trivia.persistence.entity.SubCategory;
import com.gamegenius.trivia.persistence.entity.TypeQuestion;
import lombok.Data;

import java.util.List;

@Data
public class QuestionInDto {
    private long idQuestion;
    private SubCategoryInDto subCategory;
    private String description;
    private int time;
    private TypeQuestion typeQuestion;
    private List<AnswerInDto> answers;
    private short dificultad;
}
