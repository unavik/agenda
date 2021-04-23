package com.unavik.agenda.service.impl;

import com.unavik.agenda.dao.Person;
import com.unavik.agenda.exception.NotFoundException;
import com.unavik.agenda.repository.PersonRepository;
import com.unavik.agenda.service.PersonService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Person getPerson(final Long idPerson) {
        Optional<Person> personOptional = personRepository.findById(idPerson);
        if (personOptional.isPresent()) {
            return personOptional.get();
        }
        throw new NotFoundException(String.format("idPerson %s not found!", idPerson.toString()));
    }

    @Override
    public Person save(final Optional<Long> idPerson, final Person person) {
        if (idPerson.isPresent()) {
            Person personEntity = getPerson(idPerson.get());
            personEntity.setLastName(person.getLastName());
            personEntity.setBirthDay(person.getBirthDay());
            personEntity.setFirstName(person.getFirstName());
            return personRepository.save(personEntity);
        } else {
            return personRepository.save(person);
        }
    }

}
