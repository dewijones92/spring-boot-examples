package com.in28minutes.springboot.rest.example.http_e2e_tests.HelloTests;

import com.in28minutes.springboot.rest.example.dtos.Person;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

public class HelloTests {
    @Test
    public void testCreateReadDelete(){
        var restTempalte = new RestTemplate();
        var url = "http://localhost:9090/hello";
        var helloDtoRequest = new Person("Dewi1", "llandeilo1");

    }

}
