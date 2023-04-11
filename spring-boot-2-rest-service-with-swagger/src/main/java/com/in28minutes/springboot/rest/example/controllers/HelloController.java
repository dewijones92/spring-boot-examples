package com.in28minutes.springboot.rest.example.controllers;
import com.in28minutes.springboot.rest.example.dtos.HelloDTO;
import com.in28minutes.springboot.rest.example.services.HelloService;
import com.in28minutes.springboot.rest.example.services.interfaces.IHelloService;
import com.in28minutes.springboot.rest.example.student.Student;
import com.in28minutes.springboot.rest.example.student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hello")
public class HelloController {
    @Autowired
    private IHelloService helloService;

    @GetMapping()
    public List<HelloDTO> getAll() {
        var hellos = helloService.getHellos();
        return hellos;
    }

    @PostMapping()
    public HelloDTO create(@RequestBody HelloDTO hello){
        return helloService.save(hello);
    }


    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id){
        helloService.deleteById(id);
    }


}