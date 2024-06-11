package com.gamegenius.trivia.service.entityservice;

import com.gamegenius.trivia.mapper.QuestionInDtoToQuestion;
import com.gamegenius.trivia.persistence.entity.Category;
import com.gamegenius.trivia.persistence.entity.Question;
import com.gamegenius.trivia.persistence.entity.SubCategory;
import com.gamegenius.trivia.persistence.entity.TypeQuestion;
import com.gamegenius.trivia.persistence.repository.QuestionRepository;
import com.gamegenius.trivia.service.dto.QuestionInDto;
import com.gamegenius.trivia.service.dto.SubCategoryInDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    private final QuestionRepository repository;
    private final QuestionInDtoToQuestion mapper;

    public QuestionService(QuestionRepository repository, QuestionInDtoToQuestion mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Question createQuestion(QuestionInDto questionInDto){
        System.out.println(questionInDto);
        Question question = mapper.map(questionInDto);
        question=this.repository.save(question);
        return question;
    }
    public QuestionInDto getQuestion(long id){
        Question question =this.repository.getById(id);
        QuestionInDto questionInDto=this.mapper.map2(question);
        return questionInDto;
    }
    public QuestionInDto getQuestionRamdon(long id,short dificultad){
        try {
            System.out.println(id);
            List<Question> question = this.repository.findQuestionRandom(id,dificultad);
            System.out.println("paso repo");
            QuestionInDto questionInDto = this.mapper.map2(question.get(0));
            System.out.println(question);
            System.out.println(questionInDto);
            return questionInDto;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    public List<QuestionInDto> getAllQuestion(){
        List<Question> questions =this.repository.findAll();
        List<QuestionInDto> questionInDtos = new ArrayList<>();
        for (Question question:questions) {
            QuestionInDto questionInDto=this.mapper.map2(question);
            questionInDtos.add(questionInDto);
        }
        return questionInDtos;
    }



    public List<Question> createTestDataQuestion(){
        try{
            QuestionInDto question = new QuestionInDto();
            List<Question> questions=new ArrayList<>();
            SubCategoryInDto subCategory=new SubCategoryInDto();
            subCategory.setIdSubCategory(3);

            // Pregunta 1
            question.setSubCategory(subCategory);
            question.setDescription("¿Qué álbum lanzó Michael Jackson en 1982 que se convirtió en el más vendido de todos los tiempos?");
            question.setTime(20); // Aumentado a 20 segundos
            question.setDificultad((short) 1);
            System.out.println(question);
            questions.add(createQuestion(question));

// Pregunta 2
            question.setSubCategory(subCategory);
            question.setDescription("¿Cuál de los siguientes artistas lanzó el álbum 'Back to Black' en 2006?");
            question.setTime(15);
            question.setDificultad((short) 2);
            questions.add(createQuestion(question));

// Pregunta 3
            question.setSubCategory(subCategory);
            question.setDescription("¿Quién interpreta la famosa canción 'Bohemian Rhapsody'?");
            question.setTime(20); // Aumentado a 20 segundos
            question.setDificultad((short) 1);
            questions.add(createQuestion(question));

// Pregunta 4
            question.setSubCategory(subCategory);
            question.setDescription("¿Cuál es el álbum más vendido de todos los tiempos de The Beatles?");
            question.setTime(15);
            question.setDificultad((short) 2);
            questions.add(createQuestion(question));

// Pregunta 5
            question.setSubCategory(subCategory);
            question.setDescription("¿Qué canción de Nirvana fue el sencillo principal de su álbum 'Nevermind'?");
            question.setTime(15);
            question.setDificultad((short) 2);
            questions.add(createQuestion(question));

// Pregunta 6
            question.setSubCategory(subCategory);
            question.setDescription("¿Quién interpretó la canción 'Like a Rolling Stone', lanzada en 1965?");
            question.setTime(15);
            question.setDificultad((short) 3);
            questions.add(createQuestion(question));

// Pregunta 7
            question.setSubCategory(subCategory);
            question.setDescription("¿Qué álbum lanzó Pink Floyd en 1973 que se convirtió en uno de los más vendidos de todos los tiempos?");
            question.setTime(15);
            question.setDificultad((short) 1);
            questions.add(createQuestion(question));

// Pregunta 8
            question.setSubCategory(subCategory);
            question.setDescription("¿Quién interpretó la canción 'Hey Jude', lanzada en 1968?");
            question.setTime(15);
            question.setDificultad((short) 2);
            questions.add(createQuestion(question));

// Pregunta 9
            question.setSubCategory(subCategory);
            question.setDescription("¿Cuál es el álbum más vendido de todos los tiempos de AC/DC?");
            question.setTime(15);
            question.setDificultad((short) 2);
            questions.add(createQuestion(question));

// Pregunta 10
            question.setSubCategory(subCategory);
            question.setDescription("¿Qué álbum de Adele ganó el premio Grammy al Álbum del Año en 2012?");
            question.setTime(15);
            question.setDificultad((short) 2);
            questions.add(createQuestion(question));

// Pregunta 11
            question.setSubCategory(subCategory);
            question.setDescription("¿Quién interpretó la canción 'Stairway to Heaven', lanzada en 1971?");
            question.setTime(15);
            question.setDificultad((short) 1);
            questions.add(createQuestion(question));

// Pregunta 12
            question.setSubCategory(subCategory);
            question.setDescription("¿Qué banda lanzó el álbum 'Rumours' en 1977?");
            question.setTime(15);
            question.setDificultad((short) 2);
            questions.add(createQuestion(question));

// Pregunta 13
            question.setSubCategory(subCategory);
            question.setDescription("¿Cuál de los siguientes artistas lanzó el álbum 'The Eminem Show' en 2002?");
            question.setTime(15);
            question.setDificultad((short) 3);
            questions.add(createQuestion(question));

// Pregunta 14
            question.setSubCategory(subCategory);
            question.setDescription("¿Quién interpretó la canción 'Hotel California', lanzada en 1977?");
            question.setTime(15);
            question.setDificultad((short) 1);
            questions.add(createQuestion(question));

// Pregunta 15
            question.setSubCategory(subCategory);
            question.setDescription("¿Qué álbum lanzó Bob Marley & The Wailers en 1984?");
            question.setTime(15);
            question.setDificultad((short) 3);
            questions.add(createQuestion(question));

            return questions;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
