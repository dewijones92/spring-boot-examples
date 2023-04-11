package com.in28minutes.springboot.rest.example.services.interfaces;

import com.in28minutes.springboot.rest.example.dtos.Person;

import java.util.List;

public interface IHelloService {
    List<Person> getHellos();
    Person save(Person person);

    void deleteById(Integer id);

    void testTransaction();
}
