package com.gamegenius.trivia.persistence.repository;

import com.gamegenius.trivia.persistence.entity.Achievement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AchievementRepository extends JpaRepository<Achievement, Long> {
}
