package com.in28minutes.springboot.rest.example.daos;

import com.in28minutes.springboot.rest.example.dtos.Person;
import org.springframework.data.repository.CrudRepository;

public interface IHelloRepository extends CrudRepository<Person, Integer> {
}
