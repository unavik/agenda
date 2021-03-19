package com.unavik.agenda.controller.impl;

import com.unavik.agenda.controller.PersonController;
import com.unavik.agenda.dto.PersonDto;
import com.unavik.agenda.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("person")
@RestController
public class PersonControllerImpl implements PersonController {

    private PersonService personService;

    @Autowired
    public PersonControllerImpl(final PersonService personService) {
        this.personService = personService;
    }

    @GetMapping(path = "")
    @Override
    public List<PersonDto> getPersons() {
        return personService.getPersons().stream().map(person -> new PersonDto(person)).collect(Collectors.toList());
    }

}
