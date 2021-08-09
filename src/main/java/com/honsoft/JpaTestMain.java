package com.honsoft;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.transaction.Transaction;

import com.honsoft.entity.Person;

public class JpaTestMain {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAEXAMPLE");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		
		Person person = new Person();
		
		person.setName("jpatest");
		person.setAge(20);
		
		em.persist(person);

		tx.commit();
	}

}
