package com.honsoft.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;

import com.honsoft.dto.PersonDtoAssembler;
import com.honsoft.service.PersonService;
import com.honsoft.service.PersonServiceDaoImpl;
import com.honsoft.service.PersonServiceImpl;
import com.honsoft.springbatch.listener.ApplicationContextAwareBean;

public class ApplicationConfig {
	
	@Autowired
	@Qualifier("mysqlDataSource")
	private DataSource mysqlDataSource;
	
	@Autowired
	@Qualifier("oracleDataSource")
	private DataSource oracleDataSource;
	
	@Bean
	public ApplicationContextAwareBean applicationContextAwareBean() {
		return new ApplicationContextAwareBean(mysqlDataSource);
	}

	@Bean
	public PersonService personServiceRepository() {
		return new PersonServiceImpl();
	}
	
	@Bean
	public PersonService personServiceDao() {
		return new PersonServiceDaoImpl();
	}
	
	@Bean
	public PersonDtoAssembler personDtoAssembler() {
		return new PersonDtoAssembler();
	}
	
}
