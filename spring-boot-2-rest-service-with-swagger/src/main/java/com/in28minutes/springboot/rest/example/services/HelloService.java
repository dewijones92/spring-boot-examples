package com.in28minutes.springboot.rest.example.services;

import com.in28minutes.springboot.rest.example.daos.IHelloRepository;
import com.in28minutes.springboot.rest.example.dtos.Person;
import com.in28minutes.springboot.rest.example.exceptions.RecordNotFoundException;
import com.in28minutes.springboot.rest.example.services.interfaces.IHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Service
public class HelloService implements IHelloService {

    @Autowired
    JdbcTemplate jdbcTemplate;

            @Autowired
    IHelloRepository helloRepository;

    @Override
    public List<Person> getHellos() {
        var result = new ArrayList<Person>();
        helloRepository.findAll()
                .forEach(e -> result.add(e));
        return result;
    }

    @Override
    public Person save(Person person) {
        helloRepository.save(person);
        return person;
    }

    @Override
    public void deleteById(Integer id) {
        var helloDto = helloRepository.findById(id);
        if(helloDto.isPresent()){
            helloRepository.deleteById(id);
        }
        else{
            throw new RecordNotFoundException("No helloDTO record exist for given id");
        }
    }

    @Override
    @Transactional
    public void testTransaction() {



        IntStream.range(0, 10)
                .forEach(i -> {
                    System.out.println(i);
/*                    var person = new Person();
                    person.setId(i);
                    person.setName("name: %s".formatted(i));
                    save(person);*/

                    jdbcTemplate.update("insert into person(id, location, name) values(?,?,?)", i, "dew", "llandeilo");

                });

        List<String> name = jdbcTemplate.query(" select * from person limit 10000",
                (rs, rowNum) -> rs.getString("name"));

        name.forEach(n -> System.out.println("sql res %s".formatted(n)));

    }


}
