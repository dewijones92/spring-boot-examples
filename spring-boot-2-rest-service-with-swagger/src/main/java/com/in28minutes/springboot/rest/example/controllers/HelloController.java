package com.in28minutes.springboot.rest.example.controllers;
import com.in28minutes.springboot.rest.example.dtos.HelloDTO;
import com.in28minutes.springboot.rest.example.services.HelloService;
import com.in28minutes.springboot.rest.example.services.interfaces.IHelloService;
import com.in28minutes.springboot.rest.example.student.Student;
import com.in28minutes.springboot.rest.example.student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hello")
public class HelloController {
    @Autowired
    private IHelloService helloService;

    @GetMapping()
    public List<HelloDTO> index() {
        var hellos = helloService.getHellos();
        return hellos;
    }

}