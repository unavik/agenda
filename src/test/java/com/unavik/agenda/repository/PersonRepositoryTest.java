package com.unavik.agenda.repository;

import com.unavik.agenda.dao.Person;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Transactional
@SpringBootTest
public class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

    @Test
    @DisplayName("Prueba para validar el guardado en DB")
    void addInvalidAddressTest() {
        Date date = new Date();
        Person person = new Person();
        person.setBirthDay(date);
        person.setFirstName("Jose");
        person.setLastName("Jose");

        person = personRepository.save(person);

        assertNotNull(person.getId());
        assertEquals(date, person.getBirthDay());
        assertEquals("Jose", person.getFirstName());
        assertEquals("Jose", person.getLastName());
    }

}
