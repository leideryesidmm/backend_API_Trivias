package com.gamegenius.trivia.controller;

import com.gamegenius.trivia.persistence.entity.*;
import com.gamegenius.trivia.service.chatgppt.ChatGPTService;
import com.gamegenius.trivia.service.dto.*;
import com.gamegenius.trivia.service.entityservice.*;
import com.gamegenius.trivia.service.googleapi.ApiService;
import com.gamegenius.trivia.service.util.Format;
import io.github.flashvayne.chatgpt.dto.ChatRequest;
import io.github.flashvayne.chatgpt.dto.ChatResponse;
import io.github.flashvayne.chatgpt.service.ChatgptService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/public")
public class Prueba {
    private final Format format;
    private final ApiService apiService;
    private final ChatgptService chatgptService;
    private final ChatGPTService chatGPTService;
    private final CategoryService categoryService;
    private final SubCategoryService subCategoryService;
    private final UserService userService;
    private final WildcardService wildcardService;
    private final UserWildcardService userWildcardService;
    private final ScoreService scoreService;

    public Prueba(Format format, ApiService apiService, ChatgptService chatgptService, ChatGPTService chatGPTService, CategoryService categoryService, SubCategoryService subCategoryService, UserService userService, WildcardService wildcardService, UserWildcardService userWildcardService, ScoreService scoreService) {
        this.format = format;
        this.apiService = apiService;
        this.chatgptService = chatgptService;
        this.chatGPTService = chatGPTService;
        this.categoryService = categoryService;
        this.subCategoryService = subCategoryService;
        this.userService = userService;
        this.wildcardService = wildcardService;
        this.userWildcardService = userWildcardService;
        this.scoreService = scoreService;
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

    @PostMapping("/User")
    public ResponseEntity<UserInDto> createUser(@RequestBody UserInDto userInDto){
        System.out.println("entroooooooooooooooooooooooooooooooooooooooooo");
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
        else return ResponseEntity.noContent().build();
    }
    @PatchMapping("/User/Score/{idUser},{idSubCategory},{score}")
    public ResponseEntity saveScoreSubcategory(@PathVariable("idUser") long idUser,
                                         @PathVariable("idSubCategory") long idSubCategory,
                                         @PathVariable("score") long score){
        try{
            this.scoreService.newMaxScore(idUser,idSubCategory,score);
            return ResponseEntity.noContent().build();
        }catch (Exception e){
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }
    @PatchMapping("/User/Score/{id},{maxScore}")
    public ResponseEntity saveScoreGk(@PathVariable("id") Long id, @PathVariable("maxScore") int maxScore){
        try{
            return this.userService.saveScoreGk(id,maxScore);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    @GetMapping("/wildcard")
    public ResponseEntity<List<WildcardInDto>> getWildcards(){
        try {
            List<WildcardInDto> wildcards = wildcardService.getAllWildcard();
            return new ResponseEntity<>(wildcards, HttpStatus.OK);
        } catch (Exception e) {
            // Log the exception
            // Logger can be used here instead of System.out.println
            System.out.println("Unexpected exception: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/user/wildcard/{id}")
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

    @PatchMapping("/User/Bombicoins/Add/{id},{amount}")
    public ResponseEntity addBombicoins(@PathVariable("id") long id, @PathVariable("amount") int amount){
        try{
            ResponseEntity responseEntity=this.userService.addBombicoins(id,amount);
            return responseEntity;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }
    @PatchMapping("/User/Bombicoins/subtract/{id},{amount}")
    public ResponseEntity subtractBombicoins(@PathVariable("id") long id, @PathVariable("amount") int amount){
        try{
            ResponseEntity responseEntity=this.userService.subtractBombicoins(id,amount);
            return responseEntity;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/chatgpt/mensage")
    public String getMenssage(@RequestParam String message){
        System.out.println(message);
        return chatgptService.sendMessage(message);
    }
    @GetMapping("/chatgpt/prompt")
    public ChatResponse prompt(@RequestParam String message){
        Integer maxTokens = 300;
        String model = "gpt-3.5-turbo";
        Double temperature = 0.5;
        Double topP = 1.0;
        ChatRequest chatRequest = new ChatRequest(model,message,maxTokens,temperature,topP);
        ChatResponse res = chatgptService.sendChatRequest(chatRequest);
        System.out.println("Response was: "+res.toString());
        return res;
    }
    @PostMapping("/Question/Random/{id},{dificulty}")
    public String getQuestion(@PathVariable("id") long id, @PathVariable("dificulty") short dificulty, @RequestBody String historyQuestions) {
        try {
            SubCategoryInDto subCategory = this.subCategoryService.getSubCategory(id);
            String resul = apiService.generateContent(subCategory.getCategory().getName(), subCategory.getName(), dificulty, historyQuestions);
            resul = format.formatJsonQuestion(resul);
            return resul;
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }
    @PostMapping("/Question/Random/")
    public String getQuestionCulturaGeneral(@RequestBody String historyQuestions) {
        try {
            CategoryInDto category = this.categoryService.getCategory(1);
            List<CategoryInDto> categoryInDtos = this.categoryService.getAllCategory();
            String resul = apiService.generateContent(category, historyQuestions, format.toStringCategorias(categoryInDtos));
            resul = format.formatJsonQuestion(resul);
            return resul;
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }



}
