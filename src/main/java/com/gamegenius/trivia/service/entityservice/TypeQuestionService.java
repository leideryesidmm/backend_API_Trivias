package com.gamegenius.trivia.service.entityservice;

import com.gamegenius.trivia.mapper.TypeQuestionInDtoToTypeQuestion;
import com.gamegenius.trivia.persistence.entity.TypeQuestion;
import com.gamegenius.trivia.persistence.repository.TypeQuestionRepository;
import com.gamegenius.trivia.service.dto.TypeQuestionInDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TypeQuestionService {
    private final TypeQuestionRepository repository;
    private final TypeQuestionInDtoToTypeQuestion mapper;

    public TypeQuestionService(TypeQuestionRepository repository, TypeQuestionInDtoToTypeQuestion mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }
    public TypeQuestion createTypeQuestion(TypeQuestionInDto typeQuestionInDto){
        TypeQuestion typeQuestion = mapper.map(typeQuestionInDto);
        typeQuestion=this.repository.save(typeQuestion);
        return typeQuestion;
    }
    public TypeQuestionInDto getTypeQuestion(int id){
        TypeQuestion typeQuestion =this.repository.getById(id);
        TypeQuestionInDto typeQuestionInDto=this.mapper.map2(typeQuestion);
        return typeQuestionInDto;
    }
    public List<TypeQuestionInDto> getAllTypeQuestion(){
        List<TypeQuestion> typeQuestions =this.repository.findAll();
        List<TypeQuestionInDto> typeQuestionInDtos = new ArrayList<>();
        for (TypeQuestion typeQuestion:typeQuestions) {
            TypeQuestionInDto typeQuestionInDto=this.mapper.map2(typeQuestion);
            typeQuestionInDtos.add(typeQuestionInDto);
        }
        return typeQuestionInDtos;
    }
}
