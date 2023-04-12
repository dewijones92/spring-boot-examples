package com.dewi.jones.services.interfaces;

import com.dewi.jones.dtos.PersonDTO;
import com.dewi.jones.entities.Cat;
import com.dewi.jones.entities.Person;

import java.util.List;

public interface IPersonService {
    List<PersonDTO> getPeople();

    Person save(PersonDTO person);

}
