package com.gamegenius.trivia.service.entityservice;

import com.gamegenius.trivia.mapper.UserInDtoToUser;
import com.gamegenius.trivia.persistence.entity.User;
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
    private final ScoreService scoreService;

    public UserService(UserRepository repository, UserInDtoToUser mapper, UserWildcardService userWildcardService, ScoreService scoreService) {
        this.repository = repository;
        this.mapper = mapper;
        this.userWildcardService = userWildcardService;
        this.scoreService = scoreService;
    }

    public UserInDto createUser(UserInDto userInDto){
        userInDto.setBombicoins(150);
        User user = mapper.map(userInDto);
        user=this.repository.save(user);
        userInDto = this.mapper.map2(user);
        this.userWildcardService.initializeWildcard(userInDto);
        this.scoreService.initializeScores(userInDto);
        return userInDto;
    }
    public UserInDto getUser(String id){
        User user =this.repository.getByIdAuth(id);
        System.out.println(user);
        UserInDto userInDto=new UserInDto();
        if(user!=null){
            userInDto=this.mapper.map2(user);
            return userInDto;
        }
        else{return null;}
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
    @Transactional
    public ResponseEntity addBombicoins(long id, int amountToAdd) {
        try {
                User user = this.repository.findById(id).orElse(null);
            if (user != null) {
                long newAmount = user.getBombicoins() + amountToAdd;
                this.repository.subtractOrAddBombiCoins(id, newAmount);
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @Transactional
    public ResponseEntity subtractBombicoins(long id, int amountTosubtract) {
        try {
            User user = this.repository.findById(id).orElse(null);
            if (user != null) {
                if(user.getBombicoins()>=amountTosubtract){
                long newAmount = user.getBombicoins() - amountTosubtract;
                this.repository.subtractOrAddBombiCoins(id, newAmount);
                return ResponseEntity.noContent().build();
                }else{
                    return ResponseEntity.internalServerError().build();
                }
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }
    @Transactional
        public ResponseEntity saveScoreGk(long id, int maxScore) {
        try {
            User user = this.repository.findById(id).orElse(null);
            if (user != null) {
                if(user.getMaxScoreGK()<maxScore){
                    this.repository.saveMaxScoreGK(id,maxScore);
                }
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
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
            userInDto.setMaxScoreGK(3);
            userInDto.setBombicoinsObtenidas(10);
            Date birthdate = new Date(2001, 1, 6);
            userInDto.setBirthdate(birthdate);

            userInDtos.add(createUser(userInDto));

            userInDto=new UserInDto();
            userInDto.setIdAuth("100047014089194065785");
            userInDto.setUser("Lymm02");
            userInDto.setNickname("Jheyner Martinez02");
            userInDto.setEmail("jheyneryesidmm@gmail.com");
            userInDto.setBombicoins(120);
            userInDto.setMaxScoreGK(5);
            userInDto.setBombicoinsObtenidas(20);
            birthdate = new Date(2001, 1, 6);
            userInDto.setBirthdate(birthdate);

            userInDtos.add(createUser(userInDto));
            return userInDtos;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    }
