package com.gamegenius.trivia.persistence.repository;

import com.gamegenius.trivia.persistence.entity.Category;
import com.gamegenius.trivia.persistence.entity.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SubCategoryRepository  extends JpaRepository<SubCategory, Long> {
    @Query("SELECT s FROM SubCategory s WHERE s.category.idCategory = :categoryId")
    List<SubCategory> findAllByCategory(long categoryId);
}
