package com.app.service;

import java.util.List;

import com.app.exception.ApplicationException;
import com.app.model.Person;

public interface PersonService {

	public abstract boolean addPerson(Person person) throws ApplicationException;

	public abstract boolean editPerson(Person person, int personId) throws ApplicationException;

	public abstract boolean deletePerson(int personId) throws ApplicationException;

	public abstract Person find(int personId) throws ApplicationException;

	public abstract List<Person> findAll();

}
