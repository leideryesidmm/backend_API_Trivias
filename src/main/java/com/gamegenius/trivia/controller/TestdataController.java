package com.gamegenius.trivia.controller;

import com.gamegenius.trivia.persistence.entity.Category;
import com.gamegenius.trivia.persistence.entity.SubCategory;
import com.gamegenius.trivia.service.dto.UserInDto;
import com.gamegenius.trivia.service.dto.WildcardInDto;
import com.gamegenius.trivia.service.entityservice.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/public/testdata")
public class TestdataController {
    private final CategoryService categoryService;
    private final SubCategoryService subCategoryService;
    private final UserService userService;
    private final WildcardService wildcardService;

    public TestdataController(CategoryService categoryService, SubCategoryService subCategoryService, UserService userService, WildcardService wildcardService) {
        this.categoryService = categoryService;
        this.subCategoryService = subCategoryService;
        this.userService = userService;
        this.wildcardService = wildcardService;
    }

    @PostMapping("/Category")
    public ResponseEntity<List<Category>> createCategoryTestData(){
        List<Category> categories=this.categoryService.createTestDataCaregory();
        if(categories!=null)
            return ResponseEntity.ok(categories);
        else return ResponseEntity.internalServerError().build();
    }
    @PostMapping("/SubCategory")
    public ResponseEntity<List<SubCategory>> createSubCategoryTestData(){
        List<SubCategory> subCategories=this.subCategoryService.createTestDataSubCaregory();
        if(subCategories!=null)
            return ResponseEntity.ok(subCategories);
        else return ResponseEntity.internalServerError().build();
    }

    @PostMapping("/User")
    public ResponseEntity<List<UserInDto>> createUserTestData(){
        List<UserInDto> userInDto=this.userService.createTestDataUser();
        if(userInDto!=null)
            return ResponseEntity.ok(userInDto);
        else return ResponseEntity.internalServerError().build();
    }
    @PostMapping("/Wildcard")
    public ResponseEntity<List<WildcardInDto>> createWildcardsTestData(){
        List<WildcardInDto> wildcardInDtos=this.wildcardService.createTestWildcard();
        if(wildcardInDtos!=null)
            return ResponseEntity.ok(wildcardInDtos);
        else return ResponseEntity.internalServerError().build();
    }
    @PostMapping("/Inicial")
    public ResponseEntity inicializerData(){
        try{
            createCategoryTestData();
            createSubCategoryTestData();
            createWildcardsTestData();
            return ResponseEntity.ok().build();
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }
}