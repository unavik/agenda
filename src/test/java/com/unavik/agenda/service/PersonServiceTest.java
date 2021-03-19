package com.unavik.agenda.service;

import com.unavik.agenda.dao.Person;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PersonServiceTest {

    @Autowired
    private PersonService personService;

    @Test
    @DisplayName("Test to add an invalid address, without street")
    void addInvalidAddressTest() {
        List<Person> persons = personService.getPersons();

        assertEquals(4, persons.size());
    }

}
