package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exception.ApplicationException;
import com.app.model.Student;

import om.app.dao.StudentDAO;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	StudentDAO studentDAO;

	@Override
	public Student getStudentByIdValidation(Student student) throws ApplicationException {
		Student student_two = null;
		if (String.valueOf(student.getId()).length() >= 5) {
			student_two = studentDAO.getStudentById(student);
		} else {
			throw new ApplicationException("Valiadtion Failed");
		}
		return student_two;
	}

}
