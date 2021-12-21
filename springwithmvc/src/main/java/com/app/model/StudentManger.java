package com.app.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class StudentManger {

	public List<Student> getAllStudents() {

		List<Student> students = new ArrayList<Student>();
		Student student = new Student(1, "Akash Ronad", "2ke19scs02", new Address("gadag", "582209", "nearbusstop"));
		Student student1 = new Student(1, "Arun", "2ke19scs03",
				new Address("huble", "582204", "nearbusstop sp office"));
		Student student2 = new Student(1, "Laxmi", "2ke19scs04", new Address("haveri", "582208", "nearbusstop haveri"));

		students.add(student2);
		students.add(student1);
		students.add(student);

		return students;

	}

}
