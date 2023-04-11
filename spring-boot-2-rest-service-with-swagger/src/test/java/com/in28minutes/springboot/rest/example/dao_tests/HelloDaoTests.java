package com.in28minutes.springboot.rest.example.dao_tests;

import com.in28minutes.springboot.rest.example.daos.IHelloRepository;
import com.in28minutes.springboot.rest.example.dtos.Person;
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
    IHelloRepository helloRepository;

    @Test
    public void testCreateReadDelete(){
        var helloDto = new Person("Dewi2", "Swansea2");
        helloRepository.save(helloDto);

        var helloDtos = helloRepository.findAll();
        Assertions.assertThat(helloDtos).extracting(Person::getName).containsOnly("Dewi2");

        helloRepository.deleteAll();
        Assertions.assertThat(helloRepository.findAll()).isEmpty();
    }
}
