package com.dewi.jones.controllers;
import com.dewi.jones.dtos.PersonDTO;
import com.dewi.jones.entities.Person;
import com.dewi.jones.services.interfaces.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private IPersonService helloService;

    @GetMapping()
    public List<PersonDTO> getAll() {
        var people = helloService.getPeople();
        return people;
    }
}