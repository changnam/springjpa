package com.honsoft.service;

import java.util.List;

import com.honsoft.entity.Person;

public interface PersonService {
    Person findPersonById(Integer id);
    void insertPerson(Person person);
    List<Person> findAllPersons();
}