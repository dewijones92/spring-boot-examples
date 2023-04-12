package com.dewi.jones.services.interfaces;

import com.dewi.jones.dtos.Cat;

import java.util.List;

public interface ICatService {
    List<Cat> getCats();
    Cat save(Cat cat);

    void deleteById(Integer id);

    void testTransaction();
}
