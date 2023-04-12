package com.dewi.jones.services;

import com.dewi.jones.daos.IPersonRepository;
import com.dewi.jones.dtos.request.PersonRequestDTO;
import com.dewi.jones.dtos.response.CatResponseDTO;
import com.dewi.jones.dtos.response.PersonResponseDTO;
import com.dewi.jones.entities.Cat;
import com.dewi.jones.entities.Person;
import com.dewi.jones.exceptions.RecordNotFoundException;
import com.dewi.jones.services.interfaces.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonService implements IPersonService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    IPersonRepository personRepo;




    @Override
    public List<PersonResponseDTO> getPeople() {
        var result = new ArrayList<PersonResponseDTO>();
        personRepo.findAll().forEach(db_result -> {
            result.add(mapPesonEntitiyToPersonResponseDTO(db_result));
        });
        return result;
    }

    @Override
    public PersonResponseDTO save(PersonRequestDTO personRequestDTO) {
        var personEntity = mapPersonRequestDTOtoPersonEntity(personRequestDTO);
        Person personSavedEntity = personRepo.save(personEntity);
        return mapPesonEntitiyToPersonResponseDTO(personSavedEntity);
    }

    @Override
    public PersonResponseDTO get(Integer id) {
        Optional<Person> person = personRepo.findById(id);
        if(person.isPresent()){
            return mapPesonEntitiyToPersonResponseDTO(person.get());
        }
        else{
            throw new RecordNotFoundException("No person record exist for given id");
        }
    }

    @Override
    public void deleteById(Integer id) {
        var person = personRepo.findById(id);
        if(person.isPresent()){
            personRepo.deleteById(id);
        }
        else{
            throw new RecordNotFoundException("No person record exist for given id");
        }
    }

    private PersonResponseDTO mapPesonEntitiyToPersonResponseDTO(Person personEntity) {
        var personDto = new PersonResponseDTO();
        personDto.setId(personEntity.getId());
        personDto.setName(personEntity.getName());
        var catsDto = personEntity.cats.stream().map(catEntity -> {
            var catResponse = new CatResponseDTO();
            catResponse.setColour(catEntity.getColour());
            catResponse.setId(catEntity.getId());
            catResponse.setName(catEntity.getName());
            return catResponse;
        });
        personDto.cats = catsDto.collect(Collectors.toSet());

        return personDto;
    }

    private Person mapPersonRequestDTOtoPersonEntity(PersonRequestDTO personRequestDTO) {
        var personEntity = new Person();
        personEntity.setName(personRequestDTO.getName());
        personEntity.setCats(personRequestDTO.cats.stream().map(c -> {
            var catEntitiy = new Cat();
            catEntitiy.setColour(c.getColour());
            catEntitiy.setLocation(c.getLocation());
            catEntitiy.setName(c.getName());
            return  catEntitiy;
        }).collect(Collectors.toSet()));

        return personEntity;
    }

}
