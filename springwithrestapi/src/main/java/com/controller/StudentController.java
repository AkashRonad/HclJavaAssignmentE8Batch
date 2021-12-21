package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.model.Student;

@RestController
public class StudentController {

	@RequestMapping(value = "/getstudent", method = RequestMethod.GET, produces = "application/json")
	public Student getStudent() {
		Student student = new Student(1, "Akash", "2ke19scs01");
		return student;
	}

	@RequestMapping(value = "/getstudentbyid/{id}", method = RequestMethod.GET, produces = "application/json")
	public Student getProduct(@PathVariable("id") int id) {

		Student student = null;

		if (id == 10) {
			student = new Student(10, "Akash Ronad", "2go14cs001");
		}

		if (id == 20) {
			student = new Student(20, "Laxmi", "2go14cs002");
		}

		return student;

	}

	@RequestMapping(value = "/students", method = RequestMethod.POST)
	public Student createStudent(@RequestBody Student student) {

		return student;

	}

	@RequestMapping(value = "/studentslist", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Student> getStudentList() {
		List<Student> students = new ArrayList<Student>();
		Student student = new Student(10, "Akash Ronad", "2ke19scs01");
		Student student1 = new Student(11, "Laxmi", "2ke19scs02");
		Student student2 = new Student(5, "Arun", "2ke19scs03");
		students.add(student2);
		students.add(student1);
		students.add(student);
		return students;

	}

}
