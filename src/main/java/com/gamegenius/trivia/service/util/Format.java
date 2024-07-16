package com.gamegenius.trivia.service.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gamegenius.trivia.service.dto.CategoryInDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Format {
    public String formatJsonQuestion(String s){
        try {
            System.out.println(s);
            String formated = "";
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(s);

            // Accede al campo "text"
            JsonNode textNode = rootNode.path("candidates")
                    .path(0)
                    .path("content")
                    .path("parts")
                    .path(0)
                    .path("text");

            if (!textNode.isMissingNode()) {
                String textContent = textNode.asText();
                // Elimina los caracteres de escape innecesarios
                String cleanedJsonString = textContent.replace("```json\\n", "")
                        .replace("\\n```", "")
                        .replace("\\n", "")
                        .replace("\\\"", "\"")
                        .replace("```json", "")
                        .replace("```", "");

                // Parsear el string limpio a un objeto JSON para formatearlo
                JsonNode cleanedJsonNode = objectMapper.readTree(cleanedJsonString);
                formated = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(cleanedJsonNode);

                // Imprimir el JSON formateado
                System.out.println(formated);
                return formated;
            } else {
            System.out.println("Campo 'text' no encontrado.");
            return null;
        }
        }catch (Exception e){
        e.printStackTrace();
        return null;
        }
    }

    public String toStringCategorias(List<CategoryInDto> categoryInDtos){
        String toSring="";
        for (CategoryInDto categoryInDto:categoryInDtos) {
            toSring+=" "+categoryInDto.getName();
        }
        return toSring;
    }
}
