package com.dewi.jones.dtos.response;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;


public class PersonResponseDTO {

    public Integer getId() {
        Function<Double, Double> log = (value) -> Math.log(value);
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

    private LocalDateTime dob;

    public LocalDateTime getDob() {
        return dob;
    }

    public void setDob(LocalDateTime dob) {
        this.dob = dob;
    }
    public Set<CatResponseDTO> cats = new HashSet<>();
}
