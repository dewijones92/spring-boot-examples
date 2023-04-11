package com.in28minutes.springboot.rest.example.services;

import com.in28minutes.springboot.rest.example.dtos.HelloDTO;
import com.in28minutes.springboot.rest.example.services.interfaces.IHelloService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HelloService implements IHelloService {
    @Override
    public List<HelloDTO> getHellos() {
        var hellos = new ArrayList();
        hellos.add(new HelloDTO("Dewi", "Llandeilo"));
        return hellos;
    }
}
