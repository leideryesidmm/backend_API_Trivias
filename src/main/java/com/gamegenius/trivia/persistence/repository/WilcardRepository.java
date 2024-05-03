package com.gamegenius.trivia.persistence.repository;

import com.gamegenius.trivia.persistence.entity.Wildcard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WilcardRepository extends JpaRepository<Wildcard, Long> {
}
