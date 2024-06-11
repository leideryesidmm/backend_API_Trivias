package com.gamegenius.trivia.service.dto;

import lombok.Data;

@Data
public class CategoryInDto {
    private long idCategory;
    private String name;
    private String description;
    private String pathImg;
}
