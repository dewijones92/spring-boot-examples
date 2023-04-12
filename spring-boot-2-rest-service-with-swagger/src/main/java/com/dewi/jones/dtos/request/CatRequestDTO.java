package com.dewi.jones.dtos.request;


public class CatRequestDTO {



    private String name;


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    private String location;

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    private String colour;


    public CatRequestDTO(String name, String location, String colour) {
        super();
        this.name = name;
        this.location = location;
        this.colour = colour;
    }

    public CatRequestDTO(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
