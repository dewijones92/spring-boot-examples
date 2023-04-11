package com.in28minutes.springboot.rest.example.services.interfaces;

import com.in28minutes.springboot.rest.example.dtos.Cat;

import java.util.List;

public interface ICatService {
    List<Cat> getHellos();
    Cat save(Cat cat);

    void deleteById(Integer id);

    void testTransaction();
}
