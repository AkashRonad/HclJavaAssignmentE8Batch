package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.DAO.PersonDao;
import com.app.exception.ApplicationException;
import com.app.model.Person;

@Service("personService")
public class PersonServiceImpl implements PersonService {

	@Autowired
	PersonDao personDao;

	@Override
	public boolean addPerson(Person person) throws ApplicationException {
		boolean addStatus = false;

		if (person != null) {
			addStatus = personDao.addPerson(person);

		} else {
			throw new ApplicationException("Data Valiadtion Is Failed");

		}
		return addStatus;

	}

	@Override
	public boolean editPerson(Person person, int personId) throws ApplicationException {
		boolean editStatus = false;

		if (person != null && personId > 0) {
			editStatus = personDao.editPerson(person, personId);

		} else {
			throw new ApplicationException("Data Validation Is Failed");

		}

		return editStatus;

	}

	@Override
	public boolean deletePerson(int personId) throws ApplicationException {
		boolean deleteStatus = false;
		if (personId > 0) {
			deleteStatus = personDao.deletePerson(personId);
		} else {
			throw new ApplicationException("Data Validation Is Failed");
		}

		return deleteStatus;

	}

	@Override
	public Person find(int personId) throws ApplicationException {

		Person person = null;
		if (personId > 0) {
			person = personDao.find(personId);
		} else {
			throw new ApplicationException("Data Validation Is Failed");

		}

		return person;
	}

	@Override
	public List<Person> findAll() {

		return personDao.findAll();
	}

}
