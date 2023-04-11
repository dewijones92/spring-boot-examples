package com.in28minutes.springboot.rest.example.hello;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello_dewi")
    public String index() {
        return "Greetings from Spring Boot!";
    }

}