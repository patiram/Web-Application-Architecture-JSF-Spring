package com.j3ltd.server.session;

import javax.ejb.*;
import com.j3ltd.server.entities.*;
import com.j3ltd.server.exceptions.*;

import javax.persistence.*;
import com.j3ltd.server.sessionremote.*;

@Stateless
public class EntityFacadeBean implements EntityFacade {
	@PersistenceContext(unitName="shoestringPU") EntityManager em;
	  
	public Person getPerson(String email) {
		Person entity = null;
		try {
			Query query = em.createQuery("SELECT p FROM Person p WHERE p.email = ?1");
			query.setParameter(1, email);
			entity = (Person) query.getSingleResult();
		}
		catch (NoResultException noneFound) {
			// if not found, just return null
		}
		return entity;
	}
	
	/**
	 * Perform last minute validation, then if OK save 
	 * entities (Person and Address in Person)
	 * @param toCreate person record to persist
	 * @return person record just created, with the
	 *     primary key set to that just insrted.
	 *  @throws PersonEntityExistsException if email given exists
	 *  @throws PersonPasswordException if password is < 6 characters long
	 *  @throws PersonEmailException if email is blank or null
	 */
	public Person createPerson(Person toCreate) 
	  throws PersonEntityExistsException,  PersonPasswordException,
	         PersonEmailException {	
		String email = toCreate.getEmail();
		if (email == null || email.trim().length() == 0) {
			throw new PersonEmailException("Length is zero");
		}
		String password = toCreate.getPassword();
		if (password == null || password.length() < 6) {
			throw new PersonPasswordException("Length is less than 6");
		}
		if (getPerson(email) != null) {
			throw new PersonEntityExistsException("Person record already exists with an email of " + toCreate.getEmail());
		}
		em.persist(toCreate);
		return toCreate;
	}
}
