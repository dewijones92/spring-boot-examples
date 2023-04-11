package com.in28minutes.springboot.rest.example.hello;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class HelloControllerTest {

    @Autowired
    private MockMvc mvc;



    //check for any import eagerly initialized bean if it has been successfully injected into an auto-wired attrib or not
    @Autowired
    HelloController helloController;


    @Autowired
    private TestRestTemplate template;


    @Test
    public void getHello() throws Exception {
        ResponseEntity<String> response = template.getForEntity("/hello_dewi", String.class);
        assertThat(response.getBody()).isEqualTo("Greetings from Spring Boot!");
    }


}