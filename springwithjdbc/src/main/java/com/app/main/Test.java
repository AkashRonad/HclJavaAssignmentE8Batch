package com.app.main;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.app.configuration.ApplicationConfig;
import com.app.model.Person;
import com.app.service.PersonService;

public class Test {

	public static void main(String[] args) {

		AbstractApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);

		PersonService personService = context.getBean("personService", PersonService.class);

		Person personAkash = new Person(11111, "Akash", "Ronad", 24);
		Person personLaxmi = new Person(22222, "Laxmi", "Paraddi", 27);
		Person personArun = new Person(33333, "Arun", "N", 29);

		personService.addPerson(personAkash);
		personService.addPerson(personLaxmi);
		personService.addPerson(personArun);

		System.out.println("Find All");
		List<Person> persons = personService.findAll();

		for (Person person2 : persons) {
			System.out.println(person2);

		}

		System.out.println("Delete the Arun");
		int deleteMe = 33333;
		personService.deletePerson(deleteMe);

		personLaxmi.setAge(30);
		personLaxmi.setFirstName("GURU");
		personLaxmi.setLastName("HS");

		System.out.println("Upadted Person Laxmi");
		int upadteMe = 22222;
		personService.editPerson(personLaxmi, upadteMe);

		System.out.println("Find person id=2");

		Person person = personService.find(22222);
		System.out.println(person);

		context.close();

	}

}
