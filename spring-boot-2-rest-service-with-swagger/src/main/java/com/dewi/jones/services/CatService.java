package com.dewi.jones.services;

import com.dewi.jones.daos.ICatRepository;
import com.dewi.jones.entities.Cat;
import com.dewi.jones.exceptions.RecordNotFoundException;
import com.dewi.jones.services.interfaces.ICatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Service
public class CatService implements ICatService {

    @Autowired
    JdbcTemplate jdbcTemplate;

            @Autowired
            ICatRepository helloRepository;

    @Override
    public List<Cat> getCats() {
        var result = new ArrayList<Cat>();
        helloRepository.findAll()
                .forEach(e -> result.add(e));
        return result;
    }

    @Override
    public Cat save(Cat cat) {
        helloRepository.save(cat);
        return cat;
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
