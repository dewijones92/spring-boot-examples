package com.dewi.jones.services;

import com.dewi.jones.daos.ICatRepository;
import com.dewi.jones.daos.IPersonRepository;
import com.dewi.jones.dtos.Cat;
import com.dewi.jones.dtos.Person;
import com.dewi.jones.exceptions.RecordNotFoundException;
import com.dewi.jones.services.interfaces.ICatService;
import com.dewi.jones.services.interfaces.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Service
public class PersonService implements IPersonService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    IPersonRepository personRepo;

    @Override
    public List<Person> getPeople() {
        var result = new ArrayList<Person>();
        personRepo.findAll()
                .forEach(e -> result.add(e));
        return result;
    }

}
