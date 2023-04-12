package com.dewi.jones.daos;

import com.dewi.jones.dtos.Cat;
import org.springframework.data.repository.CrudRepository;

public interface ICatRepository extends CrudRepository<Cat, Integer> {
}
