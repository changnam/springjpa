package com.honsoft.repository;

import org.springframework.data.repository.CrudRepository;

import com.honsoft.entity.Person;

public interface PersonRepository extends CrudRepository<Person, Integer>{

		
}
