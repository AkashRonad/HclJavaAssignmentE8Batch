package com.app.service;

import java.util.List;

import com.app.exception.ApplicationException;
import com.app.module.Employee;

public interface EmployeeService {

	public abstract boolean insertEmployeeRecordValidation(Employee employee) throws ApplicationException;

	public abstract Employee getEmployeeRecordByIdValidation(int id) throws ApplicationException;

	public abstract List<Employee> getAllEmployees() throws ApplicationException;

	public abstract boolean upadteEmployeeRecordByIdValidation(int id, Employee employee) throws ApplicationException;

	public abstract boolean deleteEmployeeRecordByIdValidation(int id) throws ApplicationException;

}
