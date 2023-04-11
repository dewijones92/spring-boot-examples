package com.in28minutes.springboot.rest.example.service_tests;

import com.in28minutes.springboot.rest.example.daos.IHelloRepository;
import com.in28minutes.springboot.rest.example.dtos.Person;
import com.in28minutes.springboot.rest.example.services.HelloService;
import com.in28minutes.springboot.rest.example.services.interfaces.IHelloService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class HelloServiceTests {

    @InjectMocks
    IHelloService helloService = new HelloService();

    @Mock
    IHelloRepository dao;

    @Test
    public void testFindAllHellos(){
        List<Person> list = new ArrayList<>();
        var hello1 = new Person("Dewi1", "Llandeilo1");
        list.add(hello1);
        when(dao.findAll()).thenReturn(list);

        var empList = helloService.getHellos();
        assertEquals(1, empList.size());
        verify(dao, times(1)).findAll();
    }

    @Test
    public void testCreateOrSaveHello(){
        var hello = new Person("Dewi2", "Swansea2");
        helloService.save(hello);
        verify(dao, times(1)).save(hello);
    }
}
