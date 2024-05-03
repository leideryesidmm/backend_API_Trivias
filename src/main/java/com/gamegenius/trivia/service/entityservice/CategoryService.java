package com.gamegenius.trivia.service.entityservice;

import com.gamegenius.trivia.mapper.CategoryInDtoToCategory;
import com.gamegenius.trivia.persistence.entity.Category;
import com.gamegenius.trivia.persistence.repository.CategoryRepository;
import com.gamegenius.trivia.service.dto.CategoryInDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository repository;
    private final CategoryInDtoToCategory mapper;
    public CategoryService(CategoryRepository repository, CategoryInDtoToCategory mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }
    public Category createCaregory(CategoryInDto categoryInDto){
        Category category = mapper.map(categoryInDto);
        category=this.repository.save(category);
        return category;
    }
    public CategoryInDto getCategory(long id){
        Category category =this.repository.getById(id);
        CategoryInDto categoryInDto=this.mapper.map2(category);
        return categoryInDto;
    }
    public List<CategoryInDto> getAllCategory(){
        List<Category> categorys =this.repository.findAll();
        List<CategoryInDto> categoryInDtos = new ArrayList<>();
        for (Category category:categorys) {
            CategoryInDto categoryInDto=this.mapper.map2(category);
            categoryInDtos.add(categoryInDto);
        }
        return categoryInDtos;
    }

    public List<Category> createTestDataCaregory(){
        try{
        CategoryInDto category = new CategoryInDto();
        List<Category> categories=new ArrayList<>();
        category.setName("Cultura General");
        category.setDescription("Explora una amplia gama de temas que abarcan desde eventos históricos hasta curiosidades actuales, desafiando tu conocimiento en diversos ámbitos.");
        categories.add(createCaregory(category));
        category.setName("Historia Mundial");
        category.setDescription("Sumérgete en los acontecimientos pasados que han moldeado nuestro mundo actual, desde civilizaciones antiguas hasta acontecimientos contemporáneos.");
        categories.add(createCaregory(category));
        category.setName("Gastronomía");
        category.setDescription("Descubre los sabores del mundo a través de la exploración de platos icónicos, ingredientes exóticos y tradiciones culinarias de diversas culturas.");
        categories.add(createCaregory(category));
        category.setName("Películas y Series");
        category.setDescription(" Sumérgete en el mundo del entretenimiento con preguntas sobre tus películas y series favoritas, desde clásicos del cine hasta los últimos éxitos de taquilla.");
        categories.add(createCaregory(category));
        category.setName("Música");
        category.setDescription(" Pon a prueba tus conocimientos sobre artistas, géneros musicales, teoria musical, letras de canciones y momentos musicales icónicos que han definido la historia de la música.");
        categories.add(createCaregory(category));
        category.setName("Literatura");
        category.setDescription("Explora el mundo de la palabra escrita con preguntas sobre libros clásicos, autores famosos, géneros literarios y citas memorables de la literatura mundial.");
        categories.add(createCaregory(category));
        category.setName("Deportes");
        category.setDescription("Prepárate para una competencia deportiva con preguntas sobre eventos deportivos, equipos famosos, récords mundiales y momentos destacados en la historia del deporte.");
        categories.add(createCaregory(category));
        category.setName("Ciencia y Tecnología");
        category.setDescription("Descubre los avances más recientes en ciencia y tecnología, desde descubrimientos fascinantes en el universo hasta innovaciones revolucionarias en el mundo digital.");
        categories.add(createCaregory(category));
        return categories;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
