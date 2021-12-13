package com.app.service;

import java.util.List;

import com.app.exception.ApplicationException;
import com.app.model.Deparment;
import com.app.model.Employee;

public interface DeparmentService {

	public abstract boolean insertRecordValiadtion(List<Employee> employee, Deparment deparment)
			throws ApplicationException;

	public abstract List<Employee> getAllRecords() throws ApplicationException;

	public abstract boolean upadteInstructorRecordByIdValidation(int id, Employee employee) throws ApplicationException;
	
	public abstract boolean deleteRecordByIdValidation(int id) throws ApplicationException;

}
