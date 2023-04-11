package com.in28minutes.springboot.rest.example.dao_tests;

import com.in28minutes.springboot.rest.example.daos.ICatRepository;
import com.in28minutes.springboot.rest.example.dtos.Cat;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class HelloDaoTests {
    @Autowired
    ICatRepository helloRepository;

    @Test
    public void testCreateReadDelete(){
        var helloDto = new Cat("Dewi2", "Swansea2", "red");
        helloRepository.save(helloDto);

        var helloDtos = helloRepository.findAll();
        Assertions.assertThat(helloDtos).extracting(Cat::getName).containsOnly("Dewi2");

        helloRepository.deleteAll();
        Assertions.assertThat(helloRepository.findAll()).isEmpty();
    }
}
