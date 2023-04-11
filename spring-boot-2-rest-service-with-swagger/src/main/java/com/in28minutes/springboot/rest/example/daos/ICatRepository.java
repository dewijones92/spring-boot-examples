package com.in28minutes.springboot.rest.example.daos;

import com.in28minutes.springboot.rest.example.dtos.Cat;
import org.springframework.data.repository.CrudRepository;

public interface ICatRepository extends CrudRepository<Cat, Integer> {
}
