package com.in28minutes.springboot.rest.example.service_tests;

import com.in28minutes.springboot.rest.example.daos.ICatRepository;
import com.in28minutes.springboot.rest.example.dtos.Cat;
import com.in28minutes.springboot.rest.example.services.CatService;
import com.in28minutes.springboot.rest.example.services.interfaces.ICatService;
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
    ICatService helloService = new CatService();

    @Mock
    ICatRepository dao;

    @Test
    public void testFindAllHellos(){
        List<Cat> list = new ArrayList<>();
        var hello1 = new Cat("Dewi1", "Llandeilo1");
        list.add(hello1);
        when(dao.findAll()).thenReturn(list);

        var empList = helloService.getHellos();
        assertEquals(1, empList.size());
        verify(dao, times(1)).findAll();
    }

    @Test
    public void testCreateOrSaveHello(){
        var hello = new Cat("Dewi2", "Swansea2");
        helloService.save(hello);
        verify(dao, times(1)).save(hello);
    }
}
