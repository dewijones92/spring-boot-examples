package com.dewi.jones.dtos;

import java.util.HashSet;
import java.util.Set;


public class PersonDTO {

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private Integer id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public Set<CatDTO> catDTOS = new HashSet<>();
}
