package com.in28minutes.springboot.rest.example.services;

import com.in28minutes.springboot.rest.example.daos.IHelloRepository;
import com.in28minutes.springboot.rest.example.dtos.HelloDTO;
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
    public List<HelloDTO> getHellos() {
        var result = new ArrayList<HelloDTO>();
        helloRepository.findAll()
                .forEach(e -> result.add(e));
        return result;
    }

    @Override
    public HelloDTO save(HelloDTO helloDTO) {
        if(helloDTO.getId() == null){
            helloRepository.save(helloDTO);
        }
        return helloDTO;
    }
}
