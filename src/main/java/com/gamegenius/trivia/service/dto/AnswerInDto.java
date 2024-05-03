package com.gamegenius.trivia.service.dto;

import com.gamegenius.trivia.persistence.entity.Question;
import lombok.Data;

@Data
public class AnswerInDto {
    private long idAnswer;
    private QuestionInDto question;
    private String description;
    private boolean correct;

}
