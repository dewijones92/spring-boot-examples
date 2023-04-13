package com.dewi.jones.tdd.integration_tests;

import com.dewi.jones.controllers.PersonController;
import com.dewi.jones.dtos.request.CatRequestDTO;
import com.dewi.jones.dtos.request.PersonRequestDTO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.HashSet;

import static org.springframework.test.util.AssertionErrors.assertTrue;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PersonIntegrationTests {
    @Autowired
    PersonController personController;

    @Test
    public void testCreateReadDelete(){

        System.out.println("DEWI BEFORE ADD");

        var personDto = new PersonRequestDTO();
        personDto.setName("dewi owner NEW 22");
        personDto.setDob(LocalDateTime.of(1992, 2, 11, 1,3,40));
        personDto.cats = new HashSet<>();
        var catRequestDTO = new CatRequestDTO();
        catRequestDTO.setName("dewi cat NEW");
        catRequestDTO.setColour("blackNEW ");

        personDto.cats.add(catRequestDTO);
        System.out.println("DEWI JUST BEFORE ADD");
        var responseDTO = personController.create(personDto);
        System.out.println("DEWI AFTER ADD");

        System.out.println("DEWI ADDED ID: %s".formatted(responseDTO.getId()));

        personController.get(responseDTO.getId());
        Assertions.assertThat(personController.get(responseDTO.getId())).hasFieldOrPropertyWithValue("name", "dewi owner NEW");

        assertTrue("true", true);
      //  personController.delete(responseDTO.getId());
    }
}
