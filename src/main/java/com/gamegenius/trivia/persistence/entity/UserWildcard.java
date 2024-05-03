package com.gamegenius.trivia.persistence.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name ="userWildcard")
public class UserWildcard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idUserWildcard;
    @ManyToOne
    @JoinColumn(name="user")
    private User user;
    @ManyToOne
    @JoinColumn(name="wildcard")
    private Wildcard wildcard;
    private int amount;
    private long totalUsed;
    private boolean unlocked;

    public UserWildcard(long idUserWildcard, User user, Wildcard wildcard, int amount, long totalUsed, boolean unlocked) {
        this.idUserWildcard = idUserWildcard;
        this.user = user;
        this.wildcard = wildcard;
        this.amount = amount;
        this.totalUsed = totalUsed;
        this.unlocked = unlocked;
    }
    public UserWildcard() {
        this.amount = 0;
        this.totalUsed = 0;
        this.unlocked = false;
    }
}
