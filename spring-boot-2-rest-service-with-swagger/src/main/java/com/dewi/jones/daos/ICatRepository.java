package com.dewi.jones.daos;

import com.dewi.jones.entities.Cat;
import org.springframework.data.repository.CrudRepository;

public interface ICatRepository extends CrudRepository<Cat, Integer> {
}
