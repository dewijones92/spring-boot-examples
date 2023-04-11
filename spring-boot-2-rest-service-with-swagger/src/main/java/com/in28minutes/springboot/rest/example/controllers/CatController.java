package com.in28minutes.springboot.rest.example.controllers;
import com.in28minutes.springboot.rest.example.dtos.Cat;
import com.in28minutes.springboot.rest.example.services.interfaces.ICatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hello")
public class CatController {
    @Autowired
    private ICatService helloService;

    @GetMapping()
    public List<Cat> getAll() {
        var hellos = helloService.getHellos();
        return hellos;
    }

    @PostMapping()
    public Cat create(@RequestBody Cat hello){
        var person = new Cat();
        person.setName("dewi");
        return helloService.save(hello);
    }

    @PostMapping("testtransaction")
    public ResponseEntity<String> testtransaction(){
         helloService.testTransaction();
         return ResponseEntity.ok("Done");
    }


    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id){
        helloService.deleteById(id);
    }


}