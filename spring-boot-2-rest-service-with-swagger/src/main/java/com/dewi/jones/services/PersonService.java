package com.dewi.jones.services;

import com.dewi.jones.daos.IPersonRepository;
import com.dewi.jones.dtos.CatDTO;
import com.dewi.jones.dtos.PersonDTO;
import com.dewi.jones.entities.Person;
import com.dewi.jones.services.interfaces.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService implements IPersonService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    IPersonRepository personRepo;

    @Override
    public List<PersonDTO> getPeople() {
        var result = new ArrayList<PersonDTO>();
        personRepo.findAll().forEach(db_result -> {
            var person = new PersonDTO();
            person.setId(db_result.getId());
            person.setName(db_result.getName());
            person.catDTOS = db_result.cats.stream().map(cat_db_result -> {
                var catDTO = new CatDTO();
                catDTO.setColour(cat_db_result.getColour());
                catDTO.setId(cat_db_result.getId());
                catDTO.setName(cat_db_result.getName());
                return catDTO;
            }).collect(Collectors.toSet());
            result.add(person);
        });
        return result;
    }

}
