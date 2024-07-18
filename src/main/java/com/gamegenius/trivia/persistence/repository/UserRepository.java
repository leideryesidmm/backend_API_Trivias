package com.gamegenius.trivia.persistence.repository;

import com.gamegenius.trivia.persistence.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {
    public User getByIdAuth(String idAuth);

    @Modifying
    @Query("UPDATE User s SET s.bombicoins=:newAmount WHERE s.id=:id")
    void subtractOrAddBombiCoins(@Param("id") long id, @Param("newAmount") long newAmount);
    @Modifying
    @Query("UPDATE User s SET s.maxScoreGK=:maxScore WHERE s.id=:id")
    void saveMaxScoreGK(@Param("id") long id, @Param("maxScore") long maxScore);
}
