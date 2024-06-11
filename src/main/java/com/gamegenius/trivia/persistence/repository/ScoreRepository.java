package com.gamegenius.trivia.persistence.repository;

import com.gamegenius.trivia.persistence.entity.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ScoreRepository extends JpaRepository<Score,Long> {
    @Query("SELECT s FROM Score s WHERE s.user.id=:idUser AND s.subCategory.idSubCategory=:idSubCategory")
    public Score getScoreByUserAndSubCategory(@Param("idUser") long idUser,
                                              @Param("idSubCategory") long idSubCategory);
    @Modifying
    @Query("UPDATE Score s SET maxScore=:maxScore WHERE s.idScore=:id")
    public void  setMaxScore(@Param("id") long id,@Param("maxScore") long maxScore);
}
