package com.hcl.app.service;

import java.util.List;

import com.hcl.app.model.Person;

public interface PersonService {

	public abstract Person createService(Person person);

	public abstract Person findByIdService(int personId);

	public abstract List<Person> findAllService();

	public abstract boolean deleteByIdService(int personId);

	public abstract Person upadateByIdService(Person person);

}
