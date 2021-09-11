package com.honsoft.dto;

import com.honsoft.entity.mysql.Person;

public class PersonDtoAssembler {
	public PersonDto writeDto(Person person) {
		PersonDto dto = new PersonDto();
		dto.setId(person.getId());
		dto.setName(person.getName());
		dto.setAge(person.getAge());

		return dto;
	}
	
	public Person readDto(PersonDto dto) {
		Person person = new Person();
		person.setId(dto.getId());
		person.setName(dto.getName());
		person.setAge(dto.getAge());

		return person;
	}
	
}
