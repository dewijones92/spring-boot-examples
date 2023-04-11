package com.in28minutes.springboot.rest.example.controller_tests;


import com.in28minutes.springboot.rest.example.controllers.CatController;
import com.in28minutes.springboot.rest.example.dtos.Cat;
import com.in28minutes.springboot.rest.example.services.interfaces.ICatService;
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
        Cat hello = new Cat("Dewi2", "Swansea");
        List<Cat> hellos = Arrays.asList(hello);
        Mockito.when(helloService.getHellos()).thenReturn(hellos);
        mockMvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(1)))
                .andExpect(jsonPath("$[0].name", Matchers.is("Dewi2")));
    }
}
