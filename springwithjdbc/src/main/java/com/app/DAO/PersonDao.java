package com.app.DAO;

import java.util.List;

import com.app.model.Person;

public interface PersonDao {

	public abstract void addPerson(Person person);

	public abstract void editPerson(Person person, int personId);

	public abstract void deletePerson(int personId);

	public abstract Person find(int personId);

	public abstract List<Person> findAll();

}
