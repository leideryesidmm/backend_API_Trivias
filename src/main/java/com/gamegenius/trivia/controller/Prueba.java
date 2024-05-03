package com.gamegenius.trivia.controller;

import com.gamegenius.trivia.persistence.entity.*;
import com.gamegenius.trivia.service.dto.*;
import com.gamegenius.trivia.service.entityservice.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/public")
public class Prueba {
    private final CategoryService categoryService;
    private final SubCategoryService subCategoryService;
    private final QuestionService questionService;
    private final AnswerService answerService;
    private final UserService userService;
    private final UserWildcardService userWildcardService;

    public Prueba(CategoryService categoryService, SubCategoryService subCategoryService, QuestionService questionService, AnswerService answerService, UserService userService, UserWildcardService userWildcardService) {
        this.categoryService = categoryService;
        this.subCategoryService = subCategoryService;
        this.questionService = questionService;
        this.answerService = answerService;
        this.userService = userService;
        this.userWildcardService = userWildcardService;
    }

    @PostMapping("/Category")
    public ResponseEntity<Category> createCategory(@RequestBody CategoryInDto categoryInDto){
        Category category=this.categoryService.createCaregory(categoryInDto);
        return ResponseEntity.ok(category);
    }
    @GetMapping("/Category")
    public ResponseEntity<List<CategoryInDto>> getAllCategory(){
        List<CategoryInDto> categoryInDtos=this.categoryService.getAllCategory();
        if(categoryInDtos!=null)
            return ResponseEntity.ok(categoryInDtos);
        else    return ResponseEntity.internalServerError().build();
    }
    @GetMapping("/Category/{id}")
    public ResponseEntity<CategoryInDto> getCategory(@PathVariable("id") long id){
        CategoryInDto categoryInDto=this.categoryService.getCategory(id);
        System.out.println(categoryInDto);
        return ResponseEntity.ok(categoryInDto);
    }

    @PostMapping("/SubCategory")
    public ResponseEntity<SubCategory> createSubCategory(@RequestBody SubCategoryInDto subCategoryInDto){
        SubCategory subCategory=this.subCategoryService.createSubCategory(subCategoryInDto);
        return ResponseEntity.ok(subCategory);
    }
    @GetMapping("/AllSubCategory/{idCategoryInDto}")
    public ResponseEntity<List<SubCategoryInDto>> getAllSubCategory(@PathVariable("idCategoryInDto") long id){
        System.out.println(id);
        List<SubCategoryInDto> subCategoryInDtos=this.subCategoryService.getAllSubCategory(id);
        if(subCategoryInDtos!=null)
            return ResponseEntity.ok(subCategoryInDtos);
        else    return ResponseEntity.internalServerError().build();
    }
    @GetMapping("/SubCategory/{id}")
    public ResponseEntity<SubCategoryInDto> getSubCategory(@PathVariable("id") long idCategoryInDto){
        SubCategoryInDto subCategoryInDto=this.subCategoryService.getSubCategory(idCategoryInDto);
        System.out.println(subCategoryInDto);
        return ResponseEntity.ok(subCategoryInDto);
    }
    @PostMapping("/Question")
    public ResponseEntity<Question> createQuestion(@RequestBody QuestionInDto questionInDto){
        Question question=this.questionService.createQuestion(questionInDto);
        if(question!=null)
            return ResponseEntity.ok(question);
        else return ResponseEntity.internalServerError().build();
    }
    @GetMapping("/Question/{id}")
    public ResponseEntity<QuestionInDto> getQuestion(@PathVariable("id") long idQuestion){
        QuestionInDto questionInDto=this.questionService.getQuestion(idQuestion);
        System.out.println(questionInDto);
        return ResponseEntity.ok(questionInDto);
    }

    @GetMapping("/Question/Random/{id}")
    public ResponseEntity<QuestionInDto> getQuestionRandom(@PathVariable("id") long id){
        try {
            QuestionInDto questionInDto = this.questionService.getQuestionRamdon(id);
            questionInDto.setAnswers(this.answerService.getAllAnswer(questionInDto.getIdQuestion()));
            System.out.println(questionInDto);

            return ResponseEntity.ok(questionInDto);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @PostMapping("/Answer")
    public ResponseEntity<Answer> createAnswer(@RequestBody AnswerInDto answerInDto){
        Answer answer=this.answerService.createAnswer(answerInDto);
        if(answer!=null)
        return ResponseEntity.ok(answer);
        else return ResponseEntity.internalServerError().build();
    }
    @GetMapping("/Answer/{id}")
    public ResponseEntity<List<AnswerInDto>> getAllAnswer(@PathVariable long id){
        List<AnswerInDto> answersInDtos=this.answerService.getAllAnswer(id);
        System.out.println(answersInDtos);
        return ResponseEntity.ok(answersInDtos);
    }
    @PostMapping("/User")
    public ResponseEntity<UserInDto> createUser(@RequestBody UserInDto userInDto){
        userInDto=this.userService.createUser(userInDto);
        if(userInDto!=null)
            return ResponseEntity.ok(userInDto);
        else return ResponseEntity.internalServerError().build();
    }
    @GetMapping("/User/{idAuth}")
    public ResponseEntity<UserInDto> getUser(@PathVariable("idAuth") String idAuth ){
        UserInDto userInDto=this.userService.getUser(idAuth);
        if(userInDto!=null)
            return ResponseEntity.ok(userInDto);
        else return ResponseEntity.internalServerError().build();
    }
    @GetMapping("/User/Wildcard/{id}")
    public ResponseEntity<List<UserWildcardInDto>> getUserWildcards(@PathVariable("id") long id){
        List<UserWildcardInDto> userWildcardInDtos=this.userWildcardService.getUserWildcards(id);
        if(userWildcardInDtos!=null)
            return ResponseEntity.ok(userWildcardInDtos);
        else return ResponseEntity.internalServerError().build();
    }
    @PatchMapping("/User/Wildcard/Desbloquear/{id},{unlocked}")
    public ResponseEntity<UserWildcardInDto> unlockWildcard(@PathVariable("id") long id, @PathVariable("unlocked") boolean unlocked){
        try{
            ResponseEntity responseEntity=this.userWildcardService.unlockWildcard(id,unlocked);
            return responseEntity;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @PatchMapping("/User/Wildcard/Subtract/{id}")
    public ResponseEntity subtractAmount(@PathVariable("id") long id){
        try{
            ResponseEntity responseEntity=this.userWildcardService.subtractAmount(id);
            if(responseEntity.getStatusCode() == HttpStatus.OK || responseEntity.getStatusCode() == HttpStatus.NO_CONTENT)
               responseEntity= this.userWildcardService.addTotalUsed(id);
            return responseEntity;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }
    @PatchMapping("/User/Wildcard/Add/{id},{amount}")
    public ResponseEntity addAmount(@PathVariable("id") long id, @PathVariable("amount") int amount){
        try{
            ResponseEntity responseEntity=this.userWildcardService.addAmount(id,amount);
            return responseEntity;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }
}
