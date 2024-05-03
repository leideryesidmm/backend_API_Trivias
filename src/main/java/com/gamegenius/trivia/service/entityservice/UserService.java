package com.gamegenius.trivia.service.entityservice;

import com.gamegenius.trivia.mapper.UserInDtoToUser;
import com.gamegenius.trivia.persistence.entity.User;
import com.gamegenius.trivia.persistence.entity.UserWildcard;
import com.gamegenius.trivia.persistence.repository.UserRepository;
import com.gamegenius.trivia.service.dto.UserInDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserService {
    private final UserRepository repository;
    private final UserInDtoToUser mapper;
    private final UserWildcardService userWildcardService;

    public UserService(UserRepository repository, UserInDtoToUser mapper, UserWildcardService userWildcardService) {
        this.repository = repository;
        this.mapper = mapper;
        this.userWildcardService = userWildcardService;
    }

    public UserInDto createUser(UserInDto userInDto){
        User user = mapper.map(userInDto);
        user=this.repository.save(user);
        userInDto = this.mapper.map2(user);
        return userInDto;
    }
    public UserInDto getUser(String id){
        User user =this.repository.getByIdAuth(id);
        UserInDto userInDto=this.mapper.map2(user);
        return userInDto;
    }
    public List<UserInDto> getAllUser(){
        List<User> users =this.repository.findAll();
        List<UserInDto> userInDtos = new ArrayList<>();
        for (User user:users) {
            UserInDto userInDto=this.mapper.map2(user);
            userInDtos.add(userInDto);
        }
        return userInDtos;
    }
    public List<UserInDto> createTestDataUser(){
        try{
            List<UserInDto> userInDtos=new ArrayList<>();
            UserInDto userInDto=new UserInDto();
            userInDto.setIdAuth("100941685638084704096");
            userInDto.setUser("Lymm01");
            userInDto.setNickname("Leider Martinez");
            userInDto.setEmail("leideryesidmm@gmail.com");
            userInDto.setBombicoins(110);
            userInDto.setMaximumstreak(3);
            userInDto.setBombicoinsObtenidas(10);
            Date birthdate = new Date(2001, 1, 6);
            userInDto.setBirthdate(birthdate);

            userInDtos.add(createUser(userInDto));
            System.out.println("use");
            System.out.println(userInDto);
            this.userWildcardService.initializeWildcard(userInDtos.get(userInDtos.size()-1));

            userInDto=new UserInDto();
            userInDto.setIdAuth("100047014089194065785");
            userInDto.setUser("Lymm02");
            userInDto.setNickname("Jheyner Martinez02");
            userInDto.setEmail("jheyneryesidmm@gmail.com");
            userInDto.setBombicoins(120);
            userInDto.setMaximumstreak(5);
            userInDto.setBombicoinsObtenidas(20);
            birthdate = new Date(2001, 1, 6);
            userInDto.setBirthdate(birthdate);

            userInDtos.add(createUser(userInDto));
            this.userWildcardService.initializeWildcard(userInDtos.get(userInDtos.size()-1));
            return userInDtos;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    }
