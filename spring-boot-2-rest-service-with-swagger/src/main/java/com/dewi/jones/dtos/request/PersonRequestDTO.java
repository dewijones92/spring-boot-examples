package com.dewi.jones.dtos.request;

import java.util.HashSet;
import java.util.Set;


public class PersonRequestDTO {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public Set<CatRequestDTO> cats = new HashSet<>();
}
