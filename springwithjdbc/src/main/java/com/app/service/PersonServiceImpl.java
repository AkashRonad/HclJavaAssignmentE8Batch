package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.DAO.PersonDao;
import com.app.model.Person;

@Service("personService")
public class PersonServiceImpl implements PersonService {

	@Autowired
	PersonDao personDao;

	@Override
	public void addPerson(Person person) {
		personDao.addPerson(person);

	}

	@Override
	public void editPerson(Person person, int personId) {
		personDao.editPerson(person, personId);

	}

	@Override
	public void deletePerson(int personId) {
		personDao.deletePerson(personId);

	}

	@Override
	public Person find(int personId) {

		return personDao.find(personId);
	}

	@Override
	public List<Person> findAll() {

		return personDao.findAll();
	}

}
