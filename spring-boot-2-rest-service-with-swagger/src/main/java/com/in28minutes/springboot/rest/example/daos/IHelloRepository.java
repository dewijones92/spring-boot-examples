package com.in28minutes.springboot.rest.example.daos;

import com.in28minutes.springboot.rest.example.dtos.HelloDTO;
import org.springframework.data.repository.CrudRepository;

public interface IHelloRepository extends CrudRepository<HelloDTO, Integer> {
}
