package com.gamegenius.trivia.mapper;

import com.gamegenius.trivia.persistence.entity.UserWildcard;
import com.gamegenius.trivia.service.dto.UserWildcardInDto;
import org.springframework.stereotype.Component;

@Component
public class UserWildcardInDtoTouUserWilcard implements IMapper<UserWildcardInDto, UserWildcard>{
    private final UserInDtoToUser mapperUser;
    private final WildcarInDtoToWilcard mapperWildcard;

    public UserWildcardInDtoTouUserWilcard(UserInDtoToUser mapperUser, WildcarInDtoToWilcard mapperWildcard) {
        this.mapperUser = mapperUser;
        this.mapperWildcard = mapperWildcard;
    }

    @Override
    public UserWildcard map(UserWildcardInDto in) {
        UserWildcard userWildcard = new UserWildcard();
        userWildcard.setIdUserWildcard(in.getIdUserWildcard());
        if(in.getUser()!=null)
            userWildcard.setUser(this.mapperUser.map(in.getUser()));
        if(in.getWildcard()!=null)
            userWildcard.setWildcard(this.mapperWildcard.map(in.getWildcard()));
        userWildcard.setTotalUsed(in.getTotalUsed());
        userWildcard.setUnlocked(in.isUnlocked());
        userWildcard.setAmount(in.getAmount());
        return userWildcard;
    }
    @Override
    public UserWildcardInDto map2(UserWildcard in) {
        UserWildcardInDto userWildcardInDto = new UserWildcardInDto();
        userWildcardInDto.setIdUserWildcard(in.getIdUserWildcard());
        if(in.getUser()!=null)
            userWildcardInDto.setUser(this.mapperUser.map2(in.getUser()));
        if(in.getWildcard()!=null)
            userWildcardInDto.setWildcard(this.mapperWildcard.map2(in.getWildcard()));
        userWildcardInDto.setTotalUsed(in.getTotalUsed());
        userWildcardInDto.setAmount(in.getAmount());
        userWildcardInDto.setUnlocked(in.isUnlocked());
        return userWildcardInDto;
    }
}
