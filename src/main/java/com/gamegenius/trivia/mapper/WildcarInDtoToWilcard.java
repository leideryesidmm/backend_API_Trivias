package com.gamegenius.trivia.mapper;

import com.gamegenius.trivia.persistence.entity.Wildcard;
import com.gamegenius.trivia.service.dto.WildcardInDto;
import org.springframework.stereotype.Component;

@Component
public class WildcarInDtoToWilcard implements IMapper<WildcardInDto, Wildcard>{
    @Override
    public Wildcard map(WildcardInDto in) {
        Wildcard wildcard = new Wildcard();
        wildcard.setIdWildcard(in.getIdWildcard());
        wildcard.setName(in.getName());
        wildcard.setDescription(in.getDescription());
        return wildcard;
    }
    @Override
    public WildcardInDto map2(Wildcard in) {
        WildcardInDto wildcardInDto = new WildcardInDto();
        wildcardInDto.setIdWildcard(in.getIdWildcard());
        wildcardInDto.setName(in.getName());
        wildcardInDto.setDescription(in.getDescription());
        return wildcardInDto;
    }
}
