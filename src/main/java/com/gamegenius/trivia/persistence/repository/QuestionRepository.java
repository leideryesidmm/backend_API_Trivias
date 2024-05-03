package com.gamegenius.trivia.persistence.repository;

import com.gamegenius.trivia.persistence.entity.Question;
import com.gamegenius.trivia.persistence.entity.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    @Query("SELECT s FROM Question s WHERE s.subCategory.idSubCategory = :id ORDER BY FUNCTION('RAND') DESC")
    List<Question> findQuestionRandom(@Param("id") long id);
}
