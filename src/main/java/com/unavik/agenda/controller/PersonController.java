package com.unavik.agenda.controller;

import com.unavik.agenda.dto.PersonDto;

import java.util.List;

public interface PersonController {

    List<PersonDto> getPersons();

    PersonDto getPerson(Long idPerson);

    PersonDto save(PersonDto personDto);

    PersonDto update(Long idPerson, PersonDto personDto);
}
