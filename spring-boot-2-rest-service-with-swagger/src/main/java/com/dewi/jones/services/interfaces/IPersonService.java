package com.dewi.jones.services.interfaces;

import com.dewi.jones.dtos.request.PersonRequestDTO;
import com.dewi.jones.dtos.response.PersonResponseDTO;
import com.dewi.jones.entities.Person;

import java.util.List;

public interface IPersonService {
    List<PersonResponseDTO> getPeople();

    PersonResponseDTO save(PersonRequestDTO person);

    void deleteById(Integer id);
}
