package com.gamegenius.trivia.mapper;

import com.gamegenius.trivia.persistence.entity.Category;
import com.gamegenius.trivia.service.dto.CategoryInDto;
import org.springframework.stereotype.Component;

@Component
public class CategoryInDtoToCategory implements IMapper<CategoryInDto, Category>{
    @Override
    public Category map(CategoryInDto in) {
        Category category = new Category();
        category.setIdCategory(in.getIdCategory());
        category.setName(in.getName());
        category.setDescription(in.getDescription());
        category.setPathImg(in.getPathImg());
        return category;
    }
    @Override
    public CategoryInDto map2(Category in) {
        CategoryInDto categoryInDto = new CategoryInDto();
        categoryInDto.setIdCategory(in.getIdCategory());
        categoryInDto.setName(in.getName());
        categoryInDto.setDescription(in.getDescription());
        categoryInDto.setPathImg(in.getPathImg());
        return categoryInDto;
    }
}
