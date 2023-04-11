package com.in28minutes.springboot.rest.example.integration_tests;

import com.in28minutes.springboot.rest.example.controllers.HelloController;
import com.in28minutes.springboot.rest.example.dtos.Person;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class HelloIntegrationTests {
    @Autowired
    HelloController helloController;

    @Test
    public void testCreateReadDelete(){
        var helloDto = new Person("dewi1", "swansea1");
        helloController.create(helloDto);
        helloController.getAll();
        Assertions.assertThat(helloController.getAll()).first().hasFieldOrPropertyWithValue("name", "dewi1");

       // helloController.delete(helloDto.getId());
    }
}
