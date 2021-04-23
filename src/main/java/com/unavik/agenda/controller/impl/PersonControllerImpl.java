package com.unavik.agenda.controller.impl;

import com.unavik.agenda.controller.PersonController;
import com.unavik.agenda.dao.Person;
import com.unavik.agenda.dto.PersonDto;
import com.unavik.agenda.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequestMapping("person")
@RestController
public class PersonControllerImpl implements PersonController {

    private PersonService personService;

    @Autowired
    public PersonControllerImpl(final PersonService personService) {
        this.personService = personService;
    }

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public List<PersonDto> getPersons() {
        return personService.getPersons().stream().map(PersonDto::new).collect(Collectors.toList());
    }

    @GetMapping(path = "{idPerson}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public PersonDto getPerson(final @PathVariable Long idPerson) {
        return new PersonDto(personService.getPerson(idPerson));
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public PersonDto save(final @RequestBody PersonDto personDto) {
        return new PersonDto(personService.save(Optional.empty(), new Person(personDto)));
    }

    @PutMapping(path = "{idPerson}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public PersonDto update(final @PathVariable Long idPerson, final @RequestBody PersonDto personDto) {
        return new PersonDto(personService.save(Optional.of(idPerson), new Person(personDto)));
    }

}
