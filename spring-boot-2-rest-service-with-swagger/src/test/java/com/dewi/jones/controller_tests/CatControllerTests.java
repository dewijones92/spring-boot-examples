package com.dewi.jones.controller_tests;


import com.dewi.jones.dtos.Cat;
import com.dewi.jones.services.interfaces.ICatService;
import com.dewi.jones.controllers.CatController;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CatController.class)
public class CatControllerTests {

    @MockBean
    ICatService helloService;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void testfindAll() throws Exception {
        Cat hello = new Cat("Dewi2", "Swansea", "Blue");
        List<Cat> hellos = Arrays.asList(hello);
        Mockito.when(helloService.getHellos()).thenReturn(hellos);
        mockMvc.perform(get("/cat"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(1)))
                .andExpect(jsonPath("$[0].name", Matchers.is("Dewi2")));
    }
}
