package com.gamegenius.trivia.persistence.repository;

import com.gamegenius.trivia.persistence.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    public User getByIdAuth(String idAuth);
}
