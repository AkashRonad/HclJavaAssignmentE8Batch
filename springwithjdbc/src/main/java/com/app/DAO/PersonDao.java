package com.app.DAO;

import java.util.List;

import com.app.model.Person;

public interface PersonDao {

	public abstract boolean addPerson(Person person);

	public abstract boolean editPerson(Person person, int personId);

	public abstract boolean deletePerson(int personId);

	public abstract Person find(int personId);

	public abstract List<Person> findAll();

}
