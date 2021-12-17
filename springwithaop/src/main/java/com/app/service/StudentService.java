package com.app.service;

import com.app.exception.ApplicationException;
import com.app.model.Student;

public interface StudentService {

	public abstract Student getStudentByIdValidation(Student student) throws ApplicationException;

}
