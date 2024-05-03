package com.gamegenius.trivia.mapper;

import com.gamegenius.trivia.persistence.entity.Achievement;
import com.gamegenius.trivia.persistence.entity.Answer;
import com.gamegenius.trivia.service.dto.AchievementInDto;
import com.gamegenius.trivia.service.dto.AnswerInDto;
import org.springframework.stereotype.Component;

@Component
public class AnswerInDtoToAnswer implements IMapper<AnswerInDto, Answer>{
    private final QuestionInDtoToQuestion mapperQuestion;

    public AnswerInDtoToAnswer(QuestionInDtoToQuestion mapperQuestion) {
        this.mapperQuestion = mapperQuestion;
    }

    @Override
    public Answer map(AnswerInDto in) {
        Answer answer= new Answer();
        answer.setIdAnswer(in.getIdAnswer());
        answer.setDescription(in.getDescription());
        if(in.getQuestion()!=null)
            answer.setQuestion(this.mapperQuestion.map(in.getQuestion()));
        answer.setCorrect(in.isCorrect());
        return answer;
    }
    @Override
    public AnswerInDto map2(Answer in) {
        AnswerInDto answerInDto = new AnswerInDto();
        answerInDto.setIdAnswer(in.getIdAnswer());
        if(in.getQuestion()!=null)
            answerInDto.setQuestion(this.mapperQuestion.map2(in.getQuestion()));
        answerInDto.setDescription(in.getDescription());
        answerInDto.setCorrect(in.isCorrect());
        return answerInDto;
    }
}
