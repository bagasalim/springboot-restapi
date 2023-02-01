package com.springbootexc.exercisespring.model.entity;

import lombok.*;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "hero")
public class Hero {

    @Id
    private String id;
    private String name;
    private String skin;
    private int damage;
    private Boolean isNewHero;




}
