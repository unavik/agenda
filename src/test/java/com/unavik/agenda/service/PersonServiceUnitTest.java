package com.unavik.agenda.service;

import com.unavik.agenda.dao.Person;
import com.unavik.agenda.repository.PersonRepository;
import com.unavik.agenda.service.impl.PersonServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class PersonServiceUnitTest {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonService personService = new PersonServiceImpl(personRepository);

    @Test
    @DisplayName("Prueba para obtener las personas dadas de alta")
    void addInvalidAddressTest() {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(1L, "First 01", "Last 01", new Date()));
        personList.add(new Person(2L, "First 02", "Last 02", new Date()));
        personList.add(new Person(3L, "First 03", "Last 03", new Date()));
        personList.add(new Person(4L, "First 04", "Last 04", new Date()));
        personList.add(new Person(5L, "First 05", "Last 05", new Date()));

        when(personRepository.findAll()).thenReturn(personList);

        List<Person> persons = personService.getPersons();

        assertEquals(5, persons.size());
    }

}
