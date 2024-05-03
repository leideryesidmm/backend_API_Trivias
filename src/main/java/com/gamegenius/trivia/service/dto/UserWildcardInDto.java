package com.gamegenius.trivia.service.dto;

import com.gamegenius.trivia.persistence.entity.User;
import com.gamegenius.trivia.persistence.entity.Wildcard;
import lombok.Data;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Data
public class UserWildcardInDto {
    private long idUserWildcard;
    private UserInDto user;
    private WildcardInDto wildcard;
    private int amount;
    private long totalUsed;
    private boolean unlocked;
}
