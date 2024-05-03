package com.gamegenius.trivia.mapper;

import com.gamegenius.trivia.persistence.entity.SubCategory;
import com.gamegenius.trivia.service.dto.SubCategoryInDto;
import org.springframework.stereotype.Component;

@Component
public class SubCategoryInDtoToSubCategory implements IMapper<SubCategoryInDto, SubCategory>{
    private final CategoryInDtoToCategory mapperCategory;

    public SubCategoryInDtoToSubCategory(CategoryInDtoToCategory mapperCategory) {
        this.mapperCategory = mapperCategory;
    }

    @Override
    public SubCategory map(SubCategoryInDto in) {
        SubCategory subCategory = new SubCategory();
        subCategory.setIdSubCategory(in.getIdSubCategory());
        if(in.getCategory()!=null)
            subCategory.setCategory(this.mapperCategory.map(in.getCategory()));
        subCategory.setName(in.getName());
        subCategory.setDescription(in.getDescription());
        return subCategory;
    }
    @Override
    public SubCategoryInDto map2(SubCategory in) {
        SubCategoryInDto subCategoryInDto = new SubCategoryInDto();
        subCategoryInDto.setIdSubCategory(in.getIdSubCategory());
        if(in.getCategory()!=null)
            subCategoryInDto.setCategory(this.mapperCategory.map2(in.getCategory()));
        subCategoryInDto.setName(in.getName());
        subCategoryInDto.setDescription(in.getDescription());
        return subCategoryInDto;
    }
}
