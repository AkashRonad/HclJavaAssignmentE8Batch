package com.app.service;

import com.app.exception.ApplicationException;
import com.app.module.Employee;

public interface EmployeeService {

	public abstract boolean insertEmployeeRecordValidation(Employee employee) throws ApplicationException;

	public abstract Employee getEmployeeRecordByIdValidation(int id) throws ApplicationException;

	public abstract Employee getEmployeeRecordByUsernameAndPasswordValidation(String username, String password)
			throws ApplicationException;

	public abstract boolean upadteEmployeeRecordByIdValidate(int id, Employee employee) throws ApplicationException;

	public abstract boolean deleteEmployeeRecordByIdValidate(int id) throws ApplicationException;

}
