package com.honsoft.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.honsoft.dto.PersonDto;
import com.honsoft.dto.PersonDtoAssembler;
import com.honsoft.entity.mysql.Person;

public class PersonServiceDaoImpl implements PersonService{
	@PersistenceContext(unitName = "oracleUnit")
	private EntityManager oracleEm;
	
	@PersistenceContext(unitName = "mysqlUnit1")
	private EntityManager mysqlEm;
	
	@Autowired
	private PersonDtoAssembler personDtoAssembler;
	
	@Override
	public PersonDto findPersonById(Integer id) {
		PersonDto dto = new PersonDto();
		//Person person = mysqlEm.find(Person.class, id);
		//dto = personDtoAssembler.writeDto(person);
		com.honsoft.entity.oracle.Person person = oracleEm.find(com.honsoft.entity.oracle.Person.class, 1);
		dto.setAge(person.getAge());
		dto.setId(person.getId());
		dto.setName(person.getName());
		
		return dto;
	}

	@Override
	@Transactional
	public void insertPerson(PersonDto person) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<PersonDto> findAllPersons() {
		// TODO Auto-generated method stub
		return null;
	}

}
