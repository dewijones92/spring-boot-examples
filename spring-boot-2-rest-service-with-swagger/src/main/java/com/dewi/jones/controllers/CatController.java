package com.dewi.jones.controllers;
import com.dewi.jones.dtos.Cat;
import com.dewi.jones.services.interfaces.ICatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cat")
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