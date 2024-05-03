package com.gamegenius.trivia.persistence.repository;

import com.gamegenius.trivia.persistence.entity.UserAchievement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAchievementRepository extends JpaRepository<UserAchievement, Long> {
}
