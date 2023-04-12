package com.dewi.jones.controllers;
import com.dewi.jones.dtos.request.PersonRequestDTO;
import com.dewi.jones.dtos.response.PersonResponseDTO;
import com.dewi.jones.entities.Cat;
import com.dewi.jones.services.interfaces.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private IPersonService personService;

    @GetMapping()
    public List<PersonResponseDTO> getAll() {
        var people = personService.getPeople();
        return people;
    }

    @PostMapping()
    public PersonResponseDTO create(@RequestBody PersonRequestDTO hello){
        var cat = new Cat();
        cat.setName("dewi");
        return personService.save(hello);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id){
        personService.deleteById(id);
    }
}