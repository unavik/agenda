package com.unavik.agenda.controller;

import com.unavik.agenda.dto.PersonDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PersonControllerTest {

    @Autowired
    private PersonController personController;

    @Test
    @DisplayName("Test to add an invalid address, without street")
    void addInvalidAddressTest() {
        List<PersonDto> persons = personController.getPersons();

        assertEquals(4, persons.size());
        assertEquals(1L, persons.get(0).getId());
        assertEquals("1985-11-28", persons.get(0).getBirthDay().toString().substring(0,10));
        assertEquals("Charly", persons.get(0).getFirstName());
        assertEquals("Brown", persons.get(0).getLastName());
    }
}
