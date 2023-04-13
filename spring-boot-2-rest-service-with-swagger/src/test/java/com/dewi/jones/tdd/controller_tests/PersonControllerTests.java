package com.dewi.jones.tdd.controller_tests;


import com.dewi.jones.controllers.PersonController;
import com.dewi.jones.dtos.response.CatResponseDTO;
import com.dewi.jones.dtos.response.PersonResponseDTO;
import com.dewi.jones.services.interfaces.IPersonService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.HashSet;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(PersonController.class)
public class PersonControllerTests {

    @MockBean
    IPersonService personService;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void testfindAll() throws Exception {
        var person = new PersonResponseDTO();
        person.setName("dewi person");
        person.cats = new HashSet<>();
        var catResponseDTO = new CatResponseDTO();
        catResponseDTO.setName("Dewi cat");
        person.cats.add(catResponseDTO);
        var personList = new ArrayList<PersonResponseDTO>();
        personList.add(person);


        Mockito.when(personService.getPeople()).thenReturn(personList);
        mockMvc.perform(get("/person"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(1)))
                .andExpect(jsonPath("$[0].name", Matchers.is("dewi person")));
    }
}
