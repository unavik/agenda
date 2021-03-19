package com.unavik.agenda.dto;

import com.unavik.agenda.dao.Person;

import java.util.Date;

public class PersonDto {

    private Long id;

    private String firstName;

    private String lastName;

    private Date birthDay;

    public PersonDto() {

    }

    public PersonDto(final Person person) {
        this.id = person.getId();
        this.firstName = person.getFirstName();
        this.lastName = person.getLastName();
        this.birthDay = person.getBirthDay();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

}
