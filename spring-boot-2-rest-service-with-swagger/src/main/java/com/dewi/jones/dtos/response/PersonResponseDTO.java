package com.dewi.jones.dtos.response;

import java.util.HashSet;
import java.util.Set;


public class PersonResponseDTO {

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

    public Set<CatResponseDTO> cats = new HashSet<>();
}
