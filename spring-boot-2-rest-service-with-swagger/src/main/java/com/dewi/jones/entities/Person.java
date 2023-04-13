package com.dewi.jones.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static jakarta.persistence.CascadeType.ALL;

@Entity
@Schema(description = "All details about the person. ")
public class Person {
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCats(Set<Cat> cats) {
        this.cats = cats;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public String getName() {
        return name;
    }

    @Schema(name = "Name should have atleast 2 characters")
    @Size(min = 2, message = "Name should have atleast 2 characters")
    private String name;


    public LocalDateTime getDob() {
        return dob;
    }

    public void setDob(LocalDateTime dob) {
        this.dob = dob;
    }

    @NotNull(message = "Dob cannot be null")
    @Column(columnDefinition = "DATETIME")
    private LocalDateTime dob;

    @OneToMany(cascade=ALL, fetch = FetchType.EAGER)
    public Set<Cat> cats = new HashSet<>();
}
