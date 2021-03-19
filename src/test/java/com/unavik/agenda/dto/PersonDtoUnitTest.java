package com.unavik.agenda.dto;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonDtoUnitTest {

    @Test
    public void testPerson() {
        Date date = new Date();

        PersonDto personDto = new PersonDto();
        personDto.setBirthDay(date);
        personDto.setFirstName("Charly");
        personDto.setLastName("Brown");
        personDto.setId(1L);

        assertEquals("Charly", personDto.getFirstName());
        assertEquals("Brown", personDto.getLastName());
        assertEquals(1L, personDto.getId());
        assertEquals(date, personDto.getBirthDay());
    }

}
