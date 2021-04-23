package com.unavik.agenda.service;

import com.unavik.agenda.dao.Person;

import java.util.List;
import java.util.Optional;

public interface PersonService {

    List<Person> getPersons();

    Person getPerson(Long idPerson);

    Person save(Optional<Long> idPerson, Person person);
}
