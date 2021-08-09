package com.honsoft.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

	@Override
	@Transactional
	public void insertPerson(Person person) {		
		personRepository.save(person);
	}

	@Override
	public List<Person> findAllPersons() {
		// TODO Auto-generated method stub
		return (List<Person>) personRepository.findAll();
	}



}