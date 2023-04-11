package com.in28minutes.springboot.rest.example.services.interfaces;

import com.in28minutes.springboot.rest.example.dtos.HelloDTO;

import java.util.List;

public interface IHelloService {
    List<HelloDTO> getHellos();
    HelloDTO save(HelloDTO helloDTO);
}
