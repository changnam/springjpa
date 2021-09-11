package com.honsoft.service;

import java.util.List;

import com.honsoft.dto.PersonDto;

public interface PersonService {
    PersonDto findPersonById(Integer id);
    void insertPerson(PersonDto person);
    List<PersonDto> findAllPersons();
}