package com.gamegenius.trivia.service.entityservice;

import com.gamegenius.trivia.mapper.WildcarInDtoToWilcard;
import com.gamegenius.trivia.persistence.entity.Wildcard;
import com.gamegenius.trivia.persistence.repository.WilcardRepository;
import com.gamegenius.trivia.service.dto.WildcardInDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WildcardService {
    private final WilcardRepository repository;
    private final WildcarInDtoToWilcard mapper;

    public WildcardService(WilcardRepository repository, WildcarInDtoToWilcard mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public WildcardInDto createWildcard(WildcardInDto wildcardInDto){
        Wildcard wildcard = mapper.map(wildcardInDto);
        wildcard=this.repository.save(wildcard);
        wildcardInDto=this.mapper.map2(wildcard);
        return wildcardInDto;
    }
    public WildcardInDto getWildCard(long id){
        Wildcard wildcard =this.repository.getById(id);
        WildcardInDto wildcardInDto=this.mapper.map2(wildcard);
        return wildcardInDto;
    }
    public List<WildcardInDto> getAllWildcard() {
        try {
            List<Wildcard> wildcards = this.repository.findAll();
            List<WildcardInDto> wildcardInDtos = new ArrayList<>();
            for (Wildcard wildcard : wildcards) {
                WildcardInDto wildcardInDto = this.mapper.map2(wildcard);
                wildcardInDtos.add(wildcardInDto);
            }
            return wildcardInDtos;
        } catch (Exception e) {
            // Log the exception
            // Logger can be used here instead of System.out.println
            System.out.println("Error retrieving wildcards: " + e.getMessage());
            // Throw a custom exception if needed
            return null;
        }
    }
    public List<WildcardInDto> createTestWildcard(){
        List<WildcardInDto> wildcardInDtos=new ArrayList<>();
        WildcardInDto wildcardInDto=new WildcardInDto();

        //Escudo
        wildcardInDto.setName("Escudo");
        wildcardInDto.setDescription("Protege tus puntos. No perderás puntos si respondes incorrectamente mientras este comodín esté activo.");
        wildcardInDto.setCost(40);
        wildcardInDto.setIcon("bi bi-shield-fill-check");
        wildcardInDtos.add(createWildcard(wildcardInDto));
        //Reloj
        wildcardInDto.setName("Reloj");
        wildcardInDto.setDescription("Gana tiempo extra. Añade tiempo al temporizador para tener más tiempo para responder.(10 seg)");
        wildcardInDto.setCost(25);
        wildcardInDto.setIcon("bi bi-alarm-fill");
        wildcardInDtos.add(createWildcard(wildcardInDto));
        //50/50
        wildcardInDto.setName("50/50");
        wildcardInDto.setDescription("Reduce las opciones. Elimina dos respuestas incorrectas, dejándote con una mejor chance de elegir la correcta.");
        wildcardInDto.setCost(30);
        wildcardInDto.setIcon("bi bi-yin-yang");
        wildcardInDtos.add(createWildcard(wildcardInDto));
        //Salto
        wildcardInDto.setName("Salto");
        wildcardInDto.setDescription("Avanza rápidamente. Salta la pregunta actual y pasa a la siguiente sin perder puntos ni tiempo.");
        wildcardInDto.setCost(30);
        wildcardInDto.setIcon("bi bi-skip-end-circle-fill");
        wildcardInDtos.add(createWildcard(wildcardInDto));
        return wildcardInDtos;
    }
}
