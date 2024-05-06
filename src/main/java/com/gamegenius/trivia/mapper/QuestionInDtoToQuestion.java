package com.gamegenius.trivia.mapper;

import com.gamegenius.trivia.persistence.entity.Question;
import com.gamegenius.trivia.service.dto.QuestionInDto;
import org.springframework.stereotype.Component;

@Component
public class QuestionInDtoToQuestion implements IMapper<QuestionInDto, Question>{
    private final SubCategoryInDtoToSubCategory mapperSubCategory;

    public QuestionInDtoToQuestion(SubCategoryInDtoToSubCategory mapperSubCategory) {
        this.mapperSubCategory = mapperSubCategory;
    }

    @Override
    public Question map(QuestionInDto in) {
        System.out.println(in);
        Question question = new Question();
        question.setIdQuestion(in.getIdQuestion());
        question.setDescription(in.getDescription());
        question.setTypeQuestion(in.getTypeQuestion());
        question.setDificultad(in.getDificultad());
        question.setTime(in.getTime());
        if(in.getSubCategory()!=null)
            question.setSubCategory(this.mapperSubCategory.map(in.getSubCategory()));
        return question;
    }
    @Override
    public QuestionInDto map2(Question in) {
        QuestionInDto questionInDto = new QuestionInDto();
        questionInDto.setIdQuestion(in.getIdQuestion());
        questionInDto.setDescription(in.getDescription());
        questionInDto.setTypeQuestion(in.getTypeQuestion());
        questionInDto.setDificultad(in.getDificultad());
        questionInDto.setTime(in.getTime());
        if(in.getSubCategory()!=null)
            questionInDto.setSubCategory(this.mapperSubCategory.map2(in.getSubCategory()));
        return questionInDto;
    }
}
