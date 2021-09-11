package com.honsoft.dao;

import java.util.List;

import com.honsoft.dto.PersonDto;

public interface PersonDao {
	 PersonDto findPersonById(Integer id);
	    void insertPerson(PersonDto person);
	    List<PersonDto> findAllPersons();
}
