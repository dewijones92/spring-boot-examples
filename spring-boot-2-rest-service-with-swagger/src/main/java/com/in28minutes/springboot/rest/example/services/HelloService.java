package com.in28minutes.springboot.rest.example.services;

import com.in28minutes.springboot.rest.example.daos.IHelloRepository;
import com.in28minutes.springboot.rest.example.dtos.HelloDTO;
import com.in28minutes.springboot.rest.example.exceptions.RecordNotFoundException;
import com.in28minutes.springboot.rest.example.services.interfaces.IHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
