package com.dewi.jones.service_tests;

import com.dewi.jones.daos.IPersonRepository;
import com.dewi.jones.entities.Person;
import com.dewi.jones.services.PersonService;
import com.dewi.jones.entities.Cat;
import com.dewi.jones.services.interfaces.IPersonService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PeopleServiceTest {

    @InjectMocks
    IPersonService personService = new PersonService();

    @Mock
    IPersonRepository dao;

    @Test
    public void testFindAllPeople(){
        List<Person> list = new ArrayList<>();
        var mockRepoResponse = new Person();
        mockRepoResponse.setId(1);
        mockRepoResponse.setName("Dewi_owner");
        var mockCat = new Cat();
        mockCat.setId(1);
        mockRepoResponse.setCats(new HashSet<Cat>(Arrays.asList(mockCat)));

        list.add(mockRepoResponse);
        when(dao.findAll()).thenReturn(list);

        var serviceResponse = personService.getPeople();
        assertEquals(serviceResponse.get(0).cats.size(), 1);
        assertEquals(1, serviceResponse.size());
        verify(dao, times(1)).findAll();
    }


}
