package com.gamegenius.trivia.persistence.repository;

import com.gamegenius.trivia.persistence.entity.TypeQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeQuestionRepository  extends JpaRepository<TypeQuestion, Integer> {
}
