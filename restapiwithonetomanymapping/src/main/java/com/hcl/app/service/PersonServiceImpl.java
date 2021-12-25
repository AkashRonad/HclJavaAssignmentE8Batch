package com.hcl.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.app.dao.PersonRepository;
import com.hcl.app.model.Person;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	PersonRepository personRepository;

	@Override
	public Person createService(Person person) {

		Person personTwo = null;
		if (person != null && person.getOrders().size() != 0) {

			personTwo = personRepository.save(person);

		}

		return personTwo;
	}

	@Override
	public Person findByIdService(int personId) {
		Person person = null;
		if (personId > 0) {
			Optional<Person> optionalPerson = personRepository.findById(personId);
			if (optionalPerson.isPresent()) {
				person = optionalPerson.get();
			}

		}

		return person;
	}

	@Override
	public List<Person> findAllService() {

		return personRepository.findAll();
	}

	@Override
	public boolean deleteByIdService(int personId) {
		boolean statusData = false;
		if (personId > 0) {
			personRepository.deleteById(personId);
			statusData = true;

		}
		return statusData;
	}

	@Override
	public Person upadateByIdService(Person person) {
		Person personTwo = null;
		if (person != null) {
			Optional<Person> optionalPerson = personRepository.findById(person.getPersonId());
			if (optionalPerson.isPresent()) {
				personTwo = personRepository.save(person);
			}

		}
		return personTwo;
	}

}
