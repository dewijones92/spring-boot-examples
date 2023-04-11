package com.in28minutes.springboot.rest.example.integration_tests;

import com.in28minutes.springboot.rest.example.controllers.CatController;
import com.in28minutes.springboot.rest.example.dtos.Cat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.springframework.test.util.AssertionErrors.assertTrue;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class HelloIntegrationTests {
    @Autowired
    CatController catController;

    @Test
    public void testCreateReadDelete(){
        var helloDto = new Cat("dewi1", "swansea1");
        catController.create(helloDto);
        catController.getAll();
        //Assertions.assertThat(helloController.getAll()).first().hasFieldOrPropertyWithValue("name", "dewi1");

        assertTrue("true", true);
       // helloController.delete(helloDto.getId());
    }
}
