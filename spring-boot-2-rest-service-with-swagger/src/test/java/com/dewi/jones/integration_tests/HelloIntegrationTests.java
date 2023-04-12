package com.dewi.jones.integration_tests;

import com.dewi.jones.controllers.PersonController;
import com.dewi.jones.dtos.request.CatRequestDTO;
import com.dewi.jones.dtos.request.PersonRequestDTO;
import com.dewi.jones.entities.Cat;
import com.dewi.jones.controllers.CatController;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.HashSet;

import static org.springframework.test.util.AssertionErrors.assertTrue;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class HelloIntegrationTests {
    @Autowired
    PersonController personController;

    @Test
    public void testCreateReadDelete(){
        var personDto = new PersonRequestDTO();
        personDto.setName("dewi owner");
        personDto.cats = new HashSet<>();
        var catRequestDTO = new CatRequestDTO();
        catRequestDTO.setName("dewi cat");
        catRequestDTO.setColour("black");

        personDto.cats.add(catRequestDTO);
        var responseDTO = personController.create(personDto);
        personController.getAll();
        Assertions.assertThat(personController.getAll()).first().hasFieldOrPropertyWithValue("name", "dewi1");

        assertTrue("true", true);
        personController.delete(responseDTO.getId());
    }
}
