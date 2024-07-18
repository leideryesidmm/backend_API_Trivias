package com.gamegenius.trivia.mapper;

import com.gamegenius.trivia.persistence.entity.User;
import com.gamegenius.trivia.service.dto.UserInDto;
import org.springframework.stereotype.Component;

@Component
public class UserInDtoToUser implements IMapper<UserInDto, User>{
    @Override
    public User map(UserInDto in) {
        User user = new User();
        user.setId(in.getIdUser());
        user.setIdAuth(in.getIdAuth());
        user.setUser(in.getUser());
        user.setNickname(in.getNickname());
        user.setBirthdate(in.getBirthdate());
        user.setEmail(in.getEmail());
        user.setBombicoins(in.getBombicoins());
        user.setMaxScoreGK(in.getMaxScoreGK());
        return user;
    }
    @Override
    public UserInDto map2(User in) {
        UserInDto userInDto = new UserInDto();
        userInDto.setIdUser(in.getId());
        userInDto.setIdAuth(in.getIdAuth());
        userInDto.setUser(in.getUser());
        userInDto.setNickname(in.getNickname());
        userInDto.setBirthdate(in.getBirthdate());
        userInDto.setEmail(in.getEmail());
        userInDto.setBombicoins(in.getBombicoins());
        userInDto.setMaxScoreGK(in.getMaxScoreGK());
        return userInDto;
    }
}
