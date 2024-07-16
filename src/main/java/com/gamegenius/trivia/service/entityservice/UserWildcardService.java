package com.gamegenius.trivia.service.entityservice;

import com.gamegenius.trivia.mapper.UserWildcardInDtoTouUserWilcard;
import com.gamegenius.trivia.persistence.entity.UserWildcard;
import com.gamegenius.trivia.persistence.repository.UserWildcardRepository;
import com.gamegenius.trivia.service.dto.UserInDto;
import com.gamegenius.trivia.service.dto.UserWildcardInDto;
import com.gamegenius.trivia.service.dto.WildcardInDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserWildcardService {
    private final UserWildcardRepository repository;
    private final UserWildcardInDtoTouUserWilcard mapper;
    private final WildcardService wildCardService;

    public UserWildcardService(UserWildcardRepository repository, UserWildcardInDtoTouUserWilcard mapper, WildcardService wildCardService) {
        this.repository = repository;
        this.mapper = mapper;
        this.wildCardService = wildCardService;
    }
    public UserWildcardInDto createUserWildcard(UserWildcardInDto userWildcardInDto){
        UserWildcard userWildcard = mapper.map(userWildcardInDto);
        userWildcard=this.repository.save(userWildcard);
        userWildcardInDto=this.mapper.map2(userWildcard);
        return userWildcardInDto;
    }
    public UserWildcardInDto getUserWildcard(long id){
        UserWildcard userWildcard =this.repository.getById(id);
        UserWildcardInDto userWildcardInDto=this.mapper.map2(userWildcard);
        return userWildcardInDto;
    }
    public List<UserWildcardInDto> getUserWildcards(long id){
        List<UserWildcard> userWildcards =this.repository.findAllByUser(id);
        List<UserWildcardInDto> userWildcardInDtos = new ArrayList<>();
        for (UserWildcard userWildcard:userWildcards) {
            UserWildcardInDto userWildcardInDto=this.mapper.map2(userWildcard);
            userWildcardInDtos.add(userWildcardInDto);
        }
        return userWildcardInDtos;
    }
    public List<UserWildcardInDto> initializeWildcard(UserInDto userInDto){
        try {
            List<WildcardInDto> wildcardInDtos = this.wildCardService.getAllWildcard();
            List<UserWildcardInDto> userWildcardInDtos = new ArrayList<>();
            for (WildcardInDto wildcardInDto : wildcardInDtos) {
                UserWildcardInDto userWildcardInDto = new UserWildcardInDto();
                userWildcardInDto.setWildcard(wildcardInDto);
                userWildcardInDto.setUser(userInDto);
                userWildcardInDtos.add(createUserWildcard(userWildcardInDto));
            }
            return userWildcardInDtos;
        }catch (Exception e){
            return null;
        }
    }
    @Transactional
    public ResponseEntity unlockWildcard(long id, boolean unlocked){
        try{
            this.repository.unlocked(id,unlocked);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }
    @Transactional
    public ResponseEntity subtractAmount(long id) {
        try {
            UserWildcard userWildcard = this.repository.findById(id).orElse(null);
            if (userWildcard != null) {
                int newAmount = userWildcard.getAmount() - 1;
                this.repository.subtractOrAdd(id, newAmount);
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
    public ResponseEntity addAmount(long id, int amountToAdd) {
        try {
            UserWildcard userWildcard = this.repository.findById(id).orElse(null);
            if (userWildcard != null) {
                int newAmount = userWildcard.getAmount() + amountToAdd;
                this.repository.subtractOrAdd(userWildcard.getIdUserWildcard(), newAmount);
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
    public ResponseEntity addTotalUsed(long id) {
        try {
            UserWildcard userWildcard = this.repository.findById(id).orElse(null);
            if (userWildcard != null) {
                long newAmount = userWildcard.getTotalUsed() + 1;
                this.repository.addTotalUsed(id, newAmount);
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }
}
