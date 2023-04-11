package com.in28minutes.springboot.rest.example.controllers;
import com.in28minutes.springboot.rest.example.dtos.Person;
import com.in28minutes.springboot.rest.example.services.interfaces.IHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hello")
public class HelloController {
    @Autowired
    private IHelloService helloService;

    @GetMapping()
    public List<Person> getAll() {
        var hellos = helloService.getHellos();
        return hellos;
    }

    @PostMapping()
    public Person create(@RequestBody Person hello){
        return helloService.save(hello);
    }


    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id){
        helloService.deleteById(id);
    }


}