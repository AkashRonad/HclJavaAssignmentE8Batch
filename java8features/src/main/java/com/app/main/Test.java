package com.app.main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.app.model.Student;

public class Test {

	public static void main(String[] args) {

		Student student = new Student(1, "Akash Ronad", 40);
		Student student1 = new Student(2, "Nahida", 24);
		Student student2 = new Student(3, "Arun", 30);
		Student student3 = new Student(4, "Laxmi", 50);

		List<Student> students = new ArrayList<Student>();
		students.add(student);
		students.add(student1);
		students.add(student2);
		students.add(student3);

		/*
		 * students.stream().filter((x) -> x.getName().startsWith("A")).filter((x) ->
		 * x.getAge() >= 40) .forEach(System.out::println);
		 */
		/*
		 * List<String> list = students.stream().map(x ->
		 * x.getName()).collect(Collectors.toList()); System.out.println(list);
		 * List<String> listone = list.stream().distinct().collect(Collectors.toList());
		 * listone.stream().sorted(Comparator.reverseOrder()).forEach(System.out::
		 * println);
		 */

		// students.stream().sorted(Comparator.comparingInt(Student::getAge)).forEach(System.out::println);
		// students.stream().sorted(Comparator.comparingInt(Student::getAge).reversed()).forEach(System.out::println);
		/*
		 * students.stream().sorted(Comparator.comparing(Student::getName).reversed()).
		 * limit(3) .forEach(System.out::println);
		 */

		students.stream().sorted(Comparator.comparing(Student::getName).reversed()).skip(1)
				.forEach(System.out::println);

		/*
		 * String[] arr =
		 * students.stream().sorted(Comparator.comparing(Student::getName).reversed()).
		 * limit(3) .map(x -> x.getName()).toArray(String[]::new); for (String string :
		 * arr) { System.out.println(string);
		 * 
		 * }
		 */

		
		
	}
}
