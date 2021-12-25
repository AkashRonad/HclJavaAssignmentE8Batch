package com.hcl.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.app.model.Person;
import com.hcl.app.service.PersonService;

@RestController
public class PersonContoller {

	@Autowired
	PersonService personService;

	@PostMapping(value = "create", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Person> create(@RequestBody Person person) {

		Person personTwo = personService.createService(person);
		ResponseEntity<Person> responseEntity = new ResponseEntity<Person>(personTwo, HttpStatus.CREATED);

		return responseEntity;

	}

	@GetMapping(value = "findById/{personId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Person> findById(@PathVariable int personId) {
		Person personTwo = personService.findByIdService(personId);
		ResponseEntity<Person> responseEntity = new ResponseEntity<Person>(personTwo, HttpStatus.FOUND);
		return responseEntity;

	}

	@GetMapping(value = "findAll")
	public List<Person> findAll() {

		return personService.findAllService();

	}

	@DeleteMapping("/deleteById/{personId}")
	public ResponseEntity<String> deleteById(@PathVariable int personId) {
		String status = null;
		boolean deleteStatus = personService.deleteByIdService(personId);
		if (deleteStatus) {
			status = "Person Record Is Deleted";
		} else {
			status = "Person Record Is Not Deleted";
		}

		ResponseEntity<String> responseEntity = new ResponseEntity<String>(status, HttpStatus.GONE);

		return responseEntity;

	}

	@PutMapping("/upadateRecordById")
	public ResponseEntity<Person> upadteById(@RequestBody Person person) {
		Person personTwo = personService.upadateByIdService(person);
		ResponseEntity<Person> responseEntity = new ResponseEntity<Person>(personTwo, HttpStatus.OK);

		return responseEntity;

	}

}
