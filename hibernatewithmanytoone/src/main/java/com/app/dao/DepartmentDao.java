package com.app.dao;

import java.util.List;

import com.app.exception.ApplicationException;
import com.app.model.Deparment;
import com.app.model.Employee;

public interface DepartmentDao {
	
	public abstract boolean insertRecord(List<Employee> employees, Deparment deparment) throws ApplicationException;
	public abstract List<Employee> getAllRecords() throws ApplicationException;
	public abstract boolean upadteInstructorRecordById(int id, Employee employee) throws ApplicationException;
	public abstract boolean deleteRecordById(int id) throws ApplicationException;

}
