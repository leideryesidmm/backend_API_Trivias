package com.gamegenius.trivia.persistence.repository;

import com.gamegenius.trivia.persistence.entity.UserWildcard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserWildcardRepository extends JpaRepository<UserWildcard, Long> {
    @Query("SELECT s FROM UserWildcard s WHERE s.user.id=:id")
    List<UserWildcard> findAllByUser(@Param("id") long id);
    @Modifying
    @Query("UPDATE UserWildcard s SET unlocked=:unlocked WHERE s.idUserWildcard=:id")
    void unlocked(@Param("id") long id, @Param("unlocked") boolean unlocked);
    @Modifying
    @Query("UPDATE UserWildcard s SET s.amount=:newAmount WHERE s.idUserWildcard=:id")
    void subtractOrAdd(@Param("id") long id, @Param("newAmount") int newAmount);
    @Modifying
    @Query("UPDATE UserWildcard s SET s.totalUsed=:newAmount WHERE s.idUserWildcard=:id")
    void addTotalUsed(@Param("id") long id, @Param("newAmount") long newAmount);
}
