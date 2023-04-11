package com.in28minutes.springboot.rest.example.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

@Entity
@Schema(description = "All details about the hello. ")
public class HelloDTO {
    @Id
    @GeneratedValue
    private Long id;

    @Schema(name = "Name should have atleast 2 characters")
    @Size(min = 2, message = "Name should have atleast 2 characters")
    private String name;

    @Schema(name = "Location should have atleast 2 characters")
    @Size(min = 2, message = "Name should have atleast 2 characters")
    private String location;


    public HelloDTO(String name,String location) {
        super();
        this.id = id;
        this.name = name;
        this.location = location;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
