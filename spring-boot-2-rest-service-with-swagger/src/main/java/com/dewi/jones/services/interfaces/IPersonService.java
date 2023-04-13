package com.dewi.jones.services.interfaces;

import com.dewi.jones.dtos.request.PersonRequestDTO;
import com.dewi.jones.dtos.response.PersonResponseDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface IPersonService {
    List<PersonResponseDTO> getPeople();

    PersonResponseDTO save(PersonRequestDTO person);

    PersonResponseDTO get(Integer id);

    void deleteById(Integer id);

    Long getAgeInYears(LocalDateTime currentDateTime, PersonResponseDTO person);
}
