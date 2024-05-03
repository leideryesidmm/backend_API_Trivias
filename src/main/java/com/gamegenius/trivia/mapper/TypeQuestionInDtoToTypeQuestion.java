package com.gamegenius.trivia.mapper;

import com.gamegenius.trivia.persistence.entity.TypeQuestion;
import com.gamegenius.trivia.service.dto.TypeQuestionInDto;
import org.springframework.stereotype.Component;

@Component
public class TypeQuestionInDtoToTypeQuestion implements IMapper<TypeQuestionInDto, TypeQuestion>{
    @Override
    public TypeQuestion map(TypeQuestionInDto in) {
        TypeQuestion typeQuestion = new TypeQuestion();
        typeQuestion.setIdTypeQuestion(in.getIdTypeQuestion());
        typeQuestion.setName(in.getName());
        typeQuestion.setDescription(in.getDescription());
        return typeQuestion;
    }
    @Override
    public TypeQuestionInDto map2(TypeQuestion in) {
        TypeQuestionInDto typeQuestionInDto= new TypeQuestionInDto();
        typeQuestionInDto.setIdTypeQuestion(in.getIdTypeQuestion());
        typeQuestionInDto.setName(in.getName());
        typeQuestionInDto.setDescription(in.getDescription());
        return typeQuestionInDto;
    }
}
