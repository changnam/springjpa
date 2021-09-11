package com.honsoft.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.honsoft.dto.PersonDto;
import com.honsoft.dto.PersonDtoAssembler;
import com.honsoft.entity.mysql.Person;
import com.honsoft.repository.mysql.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService {
	@Autowired
	PersonRepository personRepository;
	
	@Autowired
	PersonDtoAssembler personDtoAssembler;

	@Override
	public PersonDto findPersonById(Integer id) {
		// TODO Auto-generated method stub
		Optional<Person> person = personRepository.findById(id);
		if (person != null)
			return personDtoAssembler.writeDto(person.get());
		else
			return null;
	}

	@Override
	@Transactional
	public void insertPerson(PersonDto dto) {
		Person person = personDtoAssembler.readDto(dto);
		personRepository.save(person);
	}

	@Override
	public List<PersonDto> findAllPersons() {
		List<PersonDto> dtoList = new ArrayList<PersonDto>();
		List<Person> personList = (List<Person>) personRepository.findAll();
		
		PersonDto dto ;
		for (Person person : personList) {
			dto = personDtoAssembler.writeDto(person);
			dtoList.add(dto);
		}
		
		return dtoList;
	}



}