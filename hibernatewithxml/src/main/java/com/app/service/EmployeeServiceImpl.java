package com.app.service;

import java.util.List;

import com.app.dao.EmployeeDao;
import com.app.dao.EmployeeDaoImpl;
import com.app.exception.ApplicationException;
import com.app.module.Employee;

public class EmployeeServiceImpl implements EmployeeService {

	EmployeeDao employeeDao = new EmployeeDaoImpl();

	@Override
	public boolean insertEmployeeRecordValidation(Employee employee) throws ApplicationException {
		boolean insertStatus = false;
		if (employee != null && String.valueOf(employee.getId()).length() >= 5 && employee.getName() != null && employee.getSalary() > 0) {
			insertStatus = employeeDao.insertEmployeeRecord(employee);

		} else {

			throw new ApplicationException("Data Validation Is Failed");

		}

		return insertStatus;
	}

	@Override
	public Employee getEmployeeRecordByIdValidation(int id) throws ApplicationException {
		Employee employee = null;
		if (String.valueOf(id).length() >= 5) {
			employee = employeeDao.getEmployeeRecordById(id);

		} else {
			throw new ApplicationException("Data Validation Is Failed");
		}
		return employee;
	}

	@Override
	public List<Employee> getAllEmployees() throws ApplicationException {
		List<Employee> employees = null;
		employees = employeeDao.getAllEmployees();
		

		return employees;
	}

	@Override
	public boolean upadteEmployeeRecordByIdValidation(int id, Employee employee) throws ApplicationException {
		boolean updateStatus = false;
		if (String.valueOf(id).length() >= 5 && employee != null && employee.getName().length() >= 5
				&& employee.getSalary() > 0) {

			updateStatus = employeeDao.upadteEmployeeRecordById(id, employee);

		} else {
			throw new ApplicationException("Data Validation Is Failed");

		}

		return updateStatus;
	}

	@Override
	public boolean deleteEmployeeRecordByIdValidation(int id) throws ApplicationException {
		boolean deleteStatus = false;
		if (String.valueOf(id).length() >= 5) {
			deleteStatus = employeeDao.deleteEmployeeRecordById(id);

		} else {
			throw new ApplicationException("Data Validation Is Failed");

		}
		return deleteStatus;
	}

}
