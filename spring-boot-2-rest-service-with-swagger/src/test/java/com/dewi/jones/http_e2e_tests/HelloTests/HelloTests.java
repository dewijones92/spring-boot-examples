package com.dewi.jones.http_e2e_tests.HelloTests;

import com.dewi.jones.dtos.Cat;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

public class HelloTests {
    @Test
    public void testCreateReadDelete(){
        var restTempalte = new RestTemplate();
        var url = "http://localhost:9090/hello";
        var helloDtoRequest = new Cat("Dewi1", "llandeilo1", "red");

    }

}
