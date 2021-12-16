package com.app.main;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.app.configuration.ApplicationConfig;
import com.app.exception.ApplicationException;
import com.app.model.Person;
import com.app.service.PersonService;

public class Test {

	public static void main(String[] args) {

		AbstractApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);

		PersonService personService = context.getBean("personService", PersonService.class);
		Scanner scanner = new Scanner(System.in);
		System.out.println("1 For Insert , 2 For Edit , 3 For Delete ,4 For Find All, 5 For Find By ID");
		int userInput = scanner.nextInt();

		switch (userInput) {
		case 1:
			System.out.println("How Many Person Data You Want To Add Into Data Base ? ");
			int number = scanner.nextInt();

			for (int i = 1; i <= number; i++) {
				System.out.println("Enter Person Id");
				int personId = scanner.nextInt();
				System.out.println("Enter Person First Name");
				String firstName = scanner.next();
				System.out.println("Enter Person Last Name");
				String lastName = scanner.next();
				System.out.println("Enter Person Age");
				int age = scanner.nextInt();

				Person person = new Person(personId, firstName, lastName, age);

				try {
					boolean data = personService.addPerson(person);
					if (data) {
						System.out.println("Person Added !!!!!");
					} else {
						System.out.println("Person Not Added !!!!!");
					}
				} catch (ApplicationException e) {
					System.err.println(e.getMessage());
				}

			}

			break;

		case 2:
			System.out.println("Enter Person Id");
			int personId = scanner.nextInt();
			System.out.println("Enter Person First Name");
			String firstName = scanner.next();
			System.out.println("Enter Person Last Name");
			String lastName = scanner.next();
			System.out.println("Enter Person Age");
			int age = scanner.nextInt();

			Person person = new Person(personId, firstName, lastName, age);

			try {
				boolean data = personService.editPerson(person, personId);
				if (data) {
					System.out.println("Person Data Upadted !!!!");
				} else {
					System.out.println("Person Data Not Upadted !!!!");
				}
			} catch (ApplicationException e) {
				System.err.println(e.getMessage());
			}

			break;

		case 3:
			System.out.println("Enter Person Id");
			int personId_one = scanner.nextInt();
			try {
				boolean data = personService.deletePerson(personId_one);
				if (data) {
					System.out.println("Deleted !!!!!");
				} else {
					System.out.println("Not Deleted !!!!!");
				}
			} catch (ApplicationException e) {
				System.err.println(e.getMessage());
			}

			break;

		case 4:
			System.out.println("Find All");
			List<Person> persons = personService.findAll();
			if (persons.size() > 0) {
				for (Person person2 : persons) {
					System.out.println(person2);

				}

			} else {
				System.out.println("No Person Record In DB");
			}

			break;

		case 5:
			System.out.println("Enter Person Id");
			int personId_two = scanner.nextInt();

			Person person_two;
			try {
				person_two = personService.find(personId_two);
				if (person_two != null) {
					System.out.println(person_two);
				} else {
					System.out.println("Checking Your Passing Id");
				}

			} catch (ApplicationException e) {
				System.err.println(e.getMessage());
			}

			break;

		default:
			break;
		}

		context.close();
		scanner.close();

	}

}
