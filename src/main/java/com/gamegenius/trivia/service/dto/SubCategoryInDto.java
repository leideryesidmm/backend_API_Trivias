package com.gamegenius.trivia.service.dto;

import com.gamegenius.trivia.persistence.entity.Category;
import lombok.Data;

@Data
public class SubCategoryInDto {
    private long idSubCategory;
    private CategoryInDto category;
    private String name;
    private String description;
}
