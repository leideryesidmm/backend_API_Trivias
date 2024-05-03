package com.gamegenius.trivia.persistence.repository;

import com.gamegenius.trivia.persistence.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
    @Query("SELECT s FROM Answer s WHERE s.question.idQuestion = :id ")
    List<Answer> findAllByQuestion(@Param("id") long id);
}
