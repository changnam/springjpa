package com.honsoft.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.honsoft.dto.PersonDto;
import com.honsoft.repository.mysql.PersonRepository;

public class PersonDaoRepositoryImpl implements PersonDao{

	@Autowired
	PersonRepository personRepository;
	
	@Override
	public PersonDto findPersonById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertPerson(PersonDto person) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<PersonDto> findAllPersons() {
		// TODO Auto-generated method stub
		return null;
	}

}
