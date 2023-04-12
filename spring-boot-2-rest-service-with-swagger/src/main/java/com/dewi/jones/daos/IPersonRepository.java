package com.dewi.jones.daos;

import com.dewi.jones.dtos.Cat;
import com.dewi.jones.dtos.Person;
import org.springframework.data.repository.CrudRepository;

public interface IPersonRepository extends CrudRepository<Person, Integer> {
}
