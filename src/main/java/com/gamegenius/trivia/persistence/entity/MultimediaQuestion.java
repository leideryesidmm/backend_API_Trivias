package com.gamegenius.trivia.persistence.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "multimediaquestion")
@PrimaryKeyJoinColumn(referencedColumnName = "idQuestion")
public class MultimediaQuestion extends Question{
    private String url;
    private boolean img;

}
