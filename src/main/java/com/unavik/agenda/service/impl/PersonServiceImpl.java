package com.unavik.agenda.service.impl;

import com.unavik.agenda.dao.Person;
import com.unavik.agenda.repository.PersonRepository;
import com.unavik.agenda.service.PersonService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private PersonRepository personRepository;

    public PersonServiceImpl(final PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public List<Person> getPersons() {
        return personRepository.findAll();
    }
}
