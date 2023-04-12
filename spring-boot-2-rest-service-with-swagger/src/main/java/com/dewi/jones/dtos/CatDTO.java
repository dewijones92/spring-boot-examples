package com.dewi.jones.dtos;


public class CatDTO {

    private Integer id;


    private String name;


    private String location;

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    private String colour;


    public CatDTO(String name, String location, String colour) {
        super();
        this.id = id;
        this.name = name;
        this.location = location;
        this.colour = colour;
    }

    public CatDTO(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
