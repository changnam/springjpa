package com.honsoft;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.honsoft.entity.Person;
import com.honsoft.service.PersonService;

public class SpringJpaTestMain {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/spring/application-context.xml");
		
		PersonService ps = context.getBean(PersonService.class);
		
		Person person = ps.findPersonById(1);
		System.out.println(person.getName());

	}

}
