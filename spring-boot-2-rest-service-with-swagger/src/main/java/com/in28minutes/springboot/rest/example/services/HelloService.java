package com.in28minutes.springboot.rest.example.services;

import com.in28minutes.springboot.rest.example.daos.IHelloRepository;
import com.in28minutes.springboot.rest.example.dtos.Person;
import com.in28minutes.springboot.rest.example.exceptions.RecordNotFoundException;
import com.in28minutes.springboot.rest.example.services.interfaces.IHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HelloService implements IHelloService {
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
        if(person.getId() == null){
            helloRepository.save(person);
        }
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


}
