package com.honsoft.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.honsoft.entity.Person;
import com.honsoft.repository.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService {
	@Autowired
	PersonRepository personRepository;

	@Override
	public Person findPersonById(Integer id) {
		// TODO Auto-generated method stub
		Optional<Person> person = personRepository.findById(id);
		if (person != null)
			return person.get();
		else
			return null;
	}

}