package com.gamegenius.trivia.service.entityservice;

import com.gamegenius.trivia.mapper.SubCategoryInDtoToSubCategory;
import com.gamegenius.trivia.persistence.entity.Category;
import com.gamegenius.trivia.persistence.entity.SubCategory;
import com.gamegenius.trivia.persistence.repository.SubCategoryRepository;
import com.gamegenius.trivia.service.dto.CategoryInDto;
import com.gamegenius.trivia.service.dto.SubCategoryInDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubCategoryService {
    private final SubCategoryRepository repository;
    private final SubCategoryInDtoToSubCategory mapper;

    public SubCategoryService(SubCategoryRepository repository, SubCategoryInDtoToSubCategory mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public SubCategory createSubCategory(SubCategoryInDto subCategoryInDto){
        SubCategory subCategory = mapper.map(subCategoryInDto);
        subCategory=this.repository.save(subCategory);
        return subCategory;
    }
    public SubCategoryInDto getSubCategory(long id){
        System.out.println(id);
        SubCategory subCategory =this.repository.getById(id);
        SubCategoryInDto subCategoryInDto=this.mapper.map2(subCategory);
        return subCategoryInDto;
    }
    public List<SubCategoryInDto> getAllSubCategory(long id){
        try {
            System.out.println("entra");
            List<SubCategory> subCategorys = this.repository.findAllByCategory(id);
            System.out.println(subCategorys);
            List<SubCategoryInDto> subCategoryInDtos = new ArrayList<>();
            for (SubCategory subCategory : subCategorys) {
                SubCategoryInDto subCategoryInDto = this.mapper.map2(subCategory);
                subCategoryInDtos.add(subCategoryInDto);
            }
            System.out.println(subCategoryInDtos);
            return subCategoryInDtos;
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    public List<SubCategoryInDto> getAllSubCategorys(){
        try {
            System.out.println("entra");
            List<SubCategory> subCategorys = this.repository.findAll();
            System.out.println(subCategorys);
            List<SubCategoryInDto> subCategoryInDtos = new ArrayList<>();
            for (SubCategory subCategory : subCategorys) {
                SubCategoryInDto subCategoryInDto = this.mapper.map2(subCategory);
                subCategoryInDtos.add(subCategoryInDto);
            }
            System.out.println(subCategoryInDtos);
            return subCategoryInDtos;
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    public List<SubCategory> createTestDataSubCaregory(){
        try{
            SubCategoryInDto subCategoryInDto = new SubCategoryInDto();
            List<SubCategory> subCategories=new ArrayList<>();
            CategoryInDto category=new CategoryInDto();
            category.setIdCategory(5);

            subCategoryInDto.setCategory(category);
            subCategoryInDto.setName("Géneros musicales");
            subCategoryInDto.setDescription("Explora los diferentes estilos y géneros musicales que han surgido a lo largo del tiempo, desde el rock hasta el jazz, pasando por el hip-hop, la música clásica y muchos más.");
            subCategories.add(createSubCategory(subCategoryInDto));

            subCategoryInDto.setName("Artistas y bandas famosas");
            subCategoryInDto.setDescription("Descubre la vida y obra de músicos y grupos que han dejado una huella indeleble en la historia de la música, desde leyendas como The Beatles y Michael Jackson hasta artistas contemporáneos como Beyoncé y Ed Sheeran.");
            subCategories.add(createSubCategory(subCategoryInDto));

            subCategoryInDto.setName("Álbumes y canciones icónicas");
            subCategoryInDto.setDescription("Sumérgete en los álbumes y canciones que han definido épocas y generaciones, desde clásicos como \"Thriller\" de Michael Jackson hasta éxitos contemporáneos como \"Despacito\" de Luis Fonsi.");
            subCategories.add(createSubCategory(subCategoryInDto));

            subCategoryInDto.setName("Historia de la música");
            subCategoryInDto.setDescription("Explora los hitos y momentos clave en la evolución de la música, desde los primeros instrumentos musicales hasta la era del streaming, pasando por la invención del vinilo, el surgimiento de la radio y la revolución digital.");
            subCategories.add(createSubCategory(subCategoryInDto));

            subCategoryInDto.setName("Teoría musical");
            subCategoryInDto.setDescription("Explora los fundamentos y conceptos esenciales que constituyen la teoría musical, desde la notación y la estructura de las composiciones hasta los elementos de armonía y ritmo.");
            subCategories.add(createSubCategory(subCategoryInDto));

            subCategoryInDto.setName("Entrenamiento Auditivo");
            subCategoryInDto.setDescription("Desarrolla tus habilidades auditivas y musicales mediante ejercicios diseñados para mejorar la capacidad de reconocer notas, intervalos, acordes y ritmos, fortaleciendo así tu percepción y comprensión de la música.");
            subCategories.add(createSubCategory(subCategoryInDto));

            return subCategories;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
