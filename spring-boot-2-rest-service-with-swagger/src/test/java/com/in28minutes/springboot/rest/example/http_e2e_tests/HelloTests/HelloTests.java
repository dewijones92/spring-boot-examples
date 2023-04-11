package com.in28minutes.springboot.rest.example.http_e2e_tests.HelloTests;

import com.in28minutes.springboot.rest.example.dtos.HelloDTO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

public class HelloTests {
    @Test
    public void testCreateReadDelete(){
        var restTempalte = new RestTemplate();
        var url = "http://localhost:9090/hello";
        var helloDtoRequest = new HelloDTO("Dewi1", "llandeilo1");
        restTempalte.postForEntity(url, helloDtoRequest, HelloDTO.class);

        var getHelloDtos = restTempalte.getForObject(url, HelloDTO[].class);
        Assertions.assertThat(getHelloDtos).extracting(HelloDTO::getName).containsOnly("Bob");
    }

}
