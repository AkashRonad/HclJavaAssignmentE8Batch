package com.app.service;

import com.app.dao.EmployeeDAO;
import com.app.dao.EmployeeDAOImpl;
import com.app.exception.ApplicationException;
import com.app.module.Employee;

public class EmployeeServiceImpl implements EmployeeService {

	EmployeeDAO employeeDAO = new EmployeeDAOImpl();

	@Override
	public boolean insertEmployeeRecordValidation(Employee employee) throws ApplicationException {

		boolean data = false;

		if (employee.getUsername() != null && employee.getPassword() != null
				&& String.valueOf(employee.getId()).length() >= 5 && employee.getUsername().length() >= 5
				&& employee.getPassword().length() >= 5) {

			data = employeeDAO.insertEmployeeRecord(employee);

		} else {
			throw new ApplicationException("Validation Failed");
		}

		return data;
	}

	@Override
	public Employee getEmployeeRecordByIdValidation(int id) throws ApplicationException {
		Employee employee = null;
		if (String.valueOf(id).length() >= 5) {
			Employee employee1 = employeeDAO.getEmployeeRecordById(id);

			if (employee1 != null) {
				employee = employee1;
			} else {
				throw new ApplicationException("Data Feteching Failed In Service Layer Using ID ");

			}

		} else {
			throw new ApplicationException("Validation Failed ");
		}
		return employee;
	}

	@Override
	public Employee getEmployeeRecordByUsernameAndPasswordValidation(String username, String password)
			throws ApplicationException {
		Employee employee = null;
		if (username.length() >= 5 && password.length() >= 5) {
			Employee employee2 = employeeDAO.getEmployeeRecordByUsernameAndPassword(username, password);

			if (employee2 != null) {

				employee = employee2;
			} else {
				throw new ApplicationException("Data Feteching Failed In Service Layer Using Username And Password");
			}

		} else {
			throw new ApplicationException("Validation Failed");

		}
		return employee;
	}

	@Override
	public boolean upadteEmployeeRecordByIdValidate(int id, Employee employee) throws ApplicationException {
		boolean data = false;
		if (String.valueOf(id).length() >= 5 && employee.getUsername().length() >= 5
				&& employee.getPassword().length() >= 5) {
			data = employeeDAO.upadteEmployeeRecordById(id, employee);
		} else {
			throw new ApplicationException("Validation Failed");

		}
		return data;
	}

	@Override
	public boolean deleteEmployeeRecordByIdValidate(int id) throws ApplicationException {
		boolean data = false;
		if (String.valueOf(id).length() >= 5) {
			data = employeeDAO.deleteEmployeeRecordById(id);

		} else {
			throw new ApplicationException("Validation Failed");

		}
		return data;
	}

}
