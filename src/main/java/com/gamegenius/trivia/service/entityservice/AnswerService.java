package com.gamegenius.trivia.service.entityservice;

import com.gamegenius.trivia.mapper.AnswerInDtoToAnswer;
import com.gamegenius.trivia.persistence.entity.Answer;
import com.gamegenius.trivia.persistence.entity.Question;
import com.gamegenius.trivia.persistence.entity.SubCategory;
import com.gamegenius.trivia.persistence.repository.AnswerRepository;
import com.gamegenius.trivia.service.dto.AnswerInDto;
import com.gamegenius.trivia.service.dto.QuestionInDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnswerService {
    private final AnswerRepository repository;
    private final AnswerInDtoToAnswer mapper;

    public AnswerService(AnswerRepository repository, AnswerInDtoToAnswer mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }
    public Answer createAnswer(AnswerInDto answerInDto){
        Answer answer = mapper.map(answerInDto);
        answer=this.repository.save(answer);
        return answer;
    }
    public AnswerInDto getAnswer(long id){
        Answer answer =this.repository.getById(id);
        AnswerInDto answerInDto=this.mapper.map2(answer);
        return answerInDto;
    }
    public List<AnswerInDto> getAllAnswer(long id){
        List<Answer> answers =this.repository.findAllByQuestion(id);
        List<AnswerInDto> categoryInDtos = new ArrayList<>();
        for (Answer answer:answers) {
            AnswerInDto answerInDto=this.mapper.map2(answer);
            QuestionInDto question=answerInDto.getQuestion();
            question.setSubCategory(null);
            answerInDto.setQuestion(question);
            categoryInDtos.add(answerInDto);
        }
        return categoryInDtos;
    }
    public List<Answer> createTestDataAnswer(){
        try{
            AnswerInDto answerInDto = new AnswerInDto();
            List<Answer> answers=new ArrayList<>();

            // Pregunta 1
            QuestionInDto question=new QuestionInDto();
            question.setIdQuestion(1);
            answerInDto.setQuestion(question);

            answerInDto.setDescription("Off the Wall");
            answerInDto.setCorrect(false); // si es true, es la correcta
            answers.add(createAnswer(answerInDto));

            answerInDto.setDescription("Thriller");
            answerInDto.setCorrect(true); // si es true, es la correcta
            answers.add(createAnswer(answerInDto));

            answerInDto.setDescription("Bad");
            answerInDto.setCorrect(false); // si es true, es la correcta
            answers.add(createAnswer(answerInDto));

            answerInDto.setDescription("Dangerous");
            answerInDto.setCorrect(false); // si es true, es la correcta
            answers.add(createAnswer(answerInDto));
            // Pregunta 2
            question=new QuestionInDto();
            question.setIdQuestion(2);
            answerInDto.setQuestion(question);

            answerInDto.setDescription("Adele");
            answerInDto.setCorrect(false); // Respuesta incorrecta
            answers.add(createAnswer(answerInDto));

            answerInDto.setDescription("Amy Winehouse");
            answerInDto.setCorrect(true); // Respuesta correcta
            answers.add(createAnswer(answerInDto));

            answerInDto.setDescription("Beyoncé");
            answerInDto.setCorrect(false); // Respuesta incorrecta
            answers.add(createAnswer(answerInDto));

            answerInDto.setDescription("Lady Gaga");
            answerInDto.setCorrect(false); // Respuesta incorrecta
            answers.add(createAnswer(answerInDto));

// Pregunta 3
            question=new QuestionInDto();
            question.setIdQuestion(3);
            answerInDto.setQuestion(question);

            answerInDto.setDescription("The Beatles");
            answerInDto.setCorrect(false); // Respuesta incorrecta
            answers.add(createAnswer(answerInDto));

            answerInDto.setDescription("Queen");
            answerInDto.setCorrect(true); // Respuesta correcta
            answers.add(createAnswer(answerInDto));

            answerInDto.setDescription("Led Zeppelin");
            answerInDto.setCorrect(false); // Respuesta incorrecta
            answers.add(createAnswer(answerInDto));

            answerInDto.setDescription("Pink Floyd");
            answerInDto.setCorrect(false); // Respuesta incorrecta
            answers.add(createAnswer(answerInDto));

            // Pregunta 4
            question=new QuestionInDto();
            question.setIdQuestion(4);
            answerInDto.setQuestion(question);

            answerInDto.setDescription("Rubber Soul");
            answerInDto.setCorrect(false); // Respuesta incorrecta
            answers.add(createAnswer(answerInDto));

            answerInDto.setDescription("Abbey Road");
            answerInDto.setCorrect(false); // Respuesta incorrecta
            answers.add(createAnswer(answerInDto));

            answerInDto.setDescription("Sgt. Pepper's Lonely Hearts Club Band");
            answerInDto.setCorrect(true); // Respuesta correcta
            answers.add(createAnswer(answerInDto));

            answerInDto.setDescription("Let It Be");
            answerInDto.setCorrect(false); // Respuesta incorrecta
            answers.add(createAnswer(answerInDto));

// Pregunta 5
            question=new QuestionInDto();
            question.setIdQuestion(5);
            answerInDto.setQuestion(question);

            answerInDto.setDescription("Lithium");
            answerInDto.setCorrect(false); // Respuesta incorrecta
            answers.add(createAnswer(answerInDto));

            answerInDto.setDescription("In Bloom");
            answerInDto.setCorrect(false); // Respuesta incorrecta
            answers.add(createAnswer(answerInDto));

            answerInDto.setDescription("Smells Like Teen Spirit");
            answerInDto.setCorrect(true); // Respuesta correcta
            answers.add(createAnswer(answerInDto));

            answerInDto.setDescription("Come as You Are");
            answerInDto.setCorrect(false); // Respuesta incorrecta
            answers.add(createAnswer(answerInDto));

// Pregunta 6
            question=new QuestionInDto();
            question.setIdQuestion(6);
            answerInDto.setQuestion(question);

            answerInDto.setDescription("Bob Dylan");
            answerInDto.setCorrect(true); // Respuesta correcta
            answers.add(createAnswer(answerInDto));

            answerInDto.setDescription("The Rolling Stones");
            answerInDto.setCorrect(false); // Respuesta incorrecta
            answers.add(createAnswer(answerInDto));

            answerInDto.setDescription("Elvis Presley");
            answerInDto.setCorrect(false); // Respuesta incorrecta
            answers.add(createAnswer(answerInDto));

            answerInDto.setDescription("The Beatles");
            answerInDto.setCorrect(false); // Respuesta incorrecta
            answers.add(createAnswer(answerInDto));

            // Pregunta 7
            question=new QuestionInDto();
            question.setIdQuestion(7);
            answerInDto.setQuestion(question);

            answerInDto.setDescription("The Dark Side of the Moon");
            answerInDto.setCorrect(true); // Respuesta correcta
            answers.add(createAnswer(answerInDto));

            answerInDto.setDescription("Wish You Were Here");
            answerInDto.setCorrect(false); // Respuesta incorrecta
            answers.add(createAnswer(answerInDto));

            answerInDto.setDescription("Animals");
            answerInDto.setCorrect(false); // Respuesta incorrecta
            answers.add(createAnswer(answerInDto));

            answerInDto.setDescription("The Wall");
            answerInDto.setCorrect(false); // Respuesta incorrecta
            answers.add(createAnswer(answerInDto));

// Pregunta 8
            question=new QuestionInDto();
            question.setIdQuestion(8);
            answerInDto.setQuestion(question);

            answerInDto.setDescription("The Beatles");
            answerInDto.setCorrect(true); // Respuesta correcta
            answers.add(createAnswer(answerInDto));

            answerInDto.setDescription("The Rolling Stones");
            answerInDto.setCorrect(false); // Respuesta incorrecta
            answers.add(createAnswer(answerInDto));

            answerInDto.setDescription("Led Zeppelin");
            answerInDto.setCorrect(false); // Respuesta incorrecta
            answers.add(createAnswer(answerInDto));

            answerInDto.setDescription("The Beach Boys");
            answerInDto.setCorrect(false); // Respuesta incorrecta
            answers.add(createAnswer(answerInDto));

// Pregunta 9
            question=new QuestionInDto();
            question.setIdQuestion(9);
            answerInDto.setQuestion(question);

            answerInDto.setDescription("Highway to Hell");
            answerInDto.setCorrect(false); // Respuesta incorrecta
            answers.add(createAnswer(answerInDto));

            answerInDto.setDescription("Back in Black");
            answerInDto.setCorrect(true); // Respuesta correcta
            answers.add(createAnswer(answerInDto));

            answerInDto.setDescription("Dirty Deeds Done Dirt Cheap");
            answerInDto.setCorrect(false); // Respuesta incorrecta
            answers.add(createAnswer(answerInDto));

            answerInDto.setDescription("Let There Be Rock");
            answerInDto.setCorrect(false); // Respuesta incorrecta
            answers.add(createAnswer(answerInDto));

            // Pregunta 10
            question=new QuestionInDto();
            question.setIdQuestion(10);
            question.setDescription("¿Qué álbum de Adele ganó el premio Grammy al Álbum del Año en 2012?");
            answerInDto.setQuestion(question);

            answerInDto.setDescription("19");
            answerInDto.setCorrect(false); // Respuesta incorrecta
            answers.add(createAnswer(answerInDto));

            answerInDto.setDescription("21");
            answerInDto.setCorrect(true); // Respuesta correcta
            answers.add(createAnswer(answerInDto));

            answerInDto.setDescription("25");
            answerInDto.setCorrect(false); // Respuesta incorrecta
            answers.add(createAnswer(answerInDto));

            answerInDto.setDescription("30");
            answerInDto.setCorrect(false); // Respuesta incorrecta
            answers.add(createAnswer(answerInDto));

// Pregunta 11
            question=new QuestionInDto();
            question.setIdQuestion(11);
            question.setDescription("¿Quién interpretó la canción 'Stairway to Heaven', lanzada en 1971?");
            answerInDto.setQuestion(question);

            answerInDto.setDescription("Led Zeppelin");
            answerInDto.setCorrect(true); // Respuesta correcta
            answers.add(createAnswer(answerInDto));

            answerInDto.setDescription("Black Sabbath");
            answerInDto.setCorrect(false); // Respuesta incorrecta
            answers.add(createAnswer(answerInDto));

            answerInDto.setDescription("The Doors");
            answerInDto.setCorrect(false); // Respuesta incorrecta
            answers.add(createAnswer(answerInDto));

            answerInDto.setDescription("Deep Purple");
            answerInDto.setCorrect(false); // Respuesta incorrecta
            answers.add(createAnswer(answerInDto));

// Pregunta 12
            question=new QuestionInDto();
            question.setIdQuestion(12);
            question.setDescription("¿Qué banda lanzó el álbum 'Rumours' en 1977?");
            answerInDto.setQuestion(question);

            answerInDto.setDescription("Fleetwood Mac");
            answerInDto.setCorrect(true); // Respuesta correcta
            answers.add(createAnswer(answerInDto));

            answerInDto.setDescription("Eagles");
            answerInDto.setCorrect(false); // Respuesta incorrecta
            answers.add(createAnswer(answerInDto));

            answerInDto.setDescription("Bee Gees");
            answerInDto.setCorrect(false); // Respuesta incorrecta
            answers.add(createAnswer(answerInDto));

            answerInDto.setDescription("ABBA");
            answerInDto.setCorrect(false); // Respuesta incorrecta
            answers.add(createAnswer(answerInDto));

// Pregunta 13
            question=new QuestionInDto();
            question.setIdQuestion(13);
            question.setDescription("¿Cuál de los siguientes artistas lanzó el álbum 'The Eminem Show' en 2002?");
            answerInDto.setQuestion(question);

            answerInDto.setDescription("Jay-Z");
            answerInDto.setCorrect(false); // Respuesta incorrecta
            answers.add(createAnswer(answerInDto));

            answerInDto.setDescription("Kanye West");
            answerInDto.setCorrect(false); // Respuesta incorrecta
            answers.add(createAnswer(answerInDto));

            answerInDto.setDescription("Eminem");
            answerInDto.setCorrect(true); // Respuesta correcta
            answers.add(createAnswer(answerInDto));

            answerInDto.setDescription("Drake");
            answerInDto.setCorrect(false); // Respuesta incorrecta
            answers.add(createAnswer(answerInDto));

// Pregunta 14
            question=new QuestionInDto();
            question.setIdQuestion(14);
            question.setDescription("¿Quién interpretó la canción 'Hotel California', lanzada en 1977?");
            answerInDto.setQuestion(question);

            answerInDto.setDescription("Eagles");
            answerInDto.setCorrect(true); // Respuesta correcta
            answers.add(createAnswer(answerInDto));

            answerInDto.setDescription("Fleetwood Mac");
            answerInDto.setCorrect(false); // Respuesta incorrecta
            answers.add(createAnswer(answerInDto));

            answerInDto.setDescription("Queen");
            answerInDto.setCorrect(false); // Respuesta incorrecta
            answers.add(createAnswer(answerInDto));

            answerInDto.setDescription("Aerosmith");
            answerInDto.setCorrect(false); // Respuesta incorrecta
            answers.add(createAnswer(answerInDto));

// Pregunta 15
            question=new QuestionInDto();
            question.setIdQuestion(15);
            question.setDescription("¿Qué álbum lanzó Bob Marley & The Wailers en 1984?");
            answerInDto.setQuestion(question);

            answerInDto.setDescription("Exodus");
            answerInDto.setCorrect(false); // Respuesta incorrecta
            answers.add(createAnswer(answerInDto));

            answerInDto.setDescription("Legend");
            answerInDto.setCorrect(true); // Respuesta correcta
            answers.add(createAnswer(answerInDto));

            answerInDto.setDescription("Natty Dread");
            answerInDto.setCorrect(false); // Respuesta incorrecta
            answers.add(createAnswer(answerInDto));

            answerInDto.setDescription("Uprising");
            answerInDto.setCorrect(false); // Respuesta incorrecta
            answers.add(createAnswer(answerInDto));
            return answers;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
