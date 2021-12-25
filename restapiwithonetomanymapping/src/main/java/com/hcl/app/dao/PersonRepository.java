package com.hcl.app.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hcl.app.model.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Integer> {

	public abstract List<Person> findAll();

}
