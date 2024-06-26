package com.gamegenius.trivia.service.googleapi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class ApiService {
    @Value("${apikey}")
    private String apiKey;

    private final RestTemplate restTemplate;

    @Autowired
    public ApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String generateContent(String category, String subCategory, int dificulty) {
        String url = "https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash:generateContent?key=" + apiKey;
        String dificultadS;
        switch (dificulty) {
            case 1:
                dificultadS = "easy";
                break;
            case 2:
                dificultadS = "medium";
                break;
            case 3:
                dificultadS = "difficult";
                break;
            default:
                dificultadS = "random";
                break;
        }        System.out.println(dificultadS);
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");

        Map<String, Object> parts = new HashMap<>();
        parts.put("text", "" +
                "write a random question in Spanish about the "+category+" category, the "+subCategory+" subcategory, with "+dificultadS+" dificult. With 4 answers, 1 correct answer and 3 incorrect answers. That the format is of type json With the question, answers property that is a list and each answer has a boolean that indicates whether it is correct or incorrect,please let the boolean have \"correct\" as the property name in the json. If the question or answers have prohibited words, please you must change them to synonymus that aren't prihibited" +
                "");

        Map<String, Object> contents = new HashMap<>();
        contents.put("parts", new Object[]{parts});

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("contents", new Object[]{contents});

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);

        return response.getBody();
    }
}