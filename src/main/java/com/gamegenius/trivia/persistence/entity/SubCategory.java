package com.gamegenius.trivia.persistence.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="subcategory")
public class SubCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idSubCategory;
    @ManyToOne
    @JoinColumn(name="category")
    private Category category;
    private String name;
    private String description;
    public SubCategory() {
        this.idSubCategory = idSubCategory;
    }
    public SubCategory(long idSubCategory) {
        this.idSubCategory = idSubCategory;
    }
}
