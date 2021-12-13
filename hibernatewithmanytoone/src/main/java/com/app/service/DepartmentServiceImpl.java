package com.app.service;

import java.util.List;

import com.app.dao.DepartmentDao;
import com.app.dao.DepartmentDaoImpl;
import com.app.exception.ApplicationException;
import com.app.model.Deparment;
import com.app.model.Employee;

public class DepartmentServiceImpl implements DeparmentService {

	DepartmentDao departmentDao = new DepartmentDaoImpl();

	public boolean insertRecordValiadtion(List<Employee> employee, Deparment deparment) throws ApplicationException {
		boolean insertData = false;
		boolean status = false;

		for (Employee employee2 : employee) {

			if (String.valueOf(employee2.getId()).length() >= 5 && employee2.getPassword().length() >= 5
					&& employee2.getFirstName() != null && employee2.getLastName() != null) {
				status = true;
			}

		}

		if (status) {
			insertData = departmentDao.insertRecord(employee, deparment);

		} else {
			throw new ApplicationException("Data Validation is Failed");
		}

		return insertData;
	}

	public List<Employee> getAllRecords() throws ApplicationException {
		List<Employee> employees = null;

		employees = departmentDao.getAllRecords();

		return employees;
	}

	public boolean upadteInstructorRecordByIdValidation(int id, Employee employee) throws ApplicationException {
		boolean upadteStatus = false;
		if (String.valueOf(id).length() >= 5 && employee != null && employee.getPassword().length() >= 5) {

			upadteStatus = departmentDao.upadteInstructorRecordById(id, employee);

		} else {
			throw new ApplicationException("Data Validation is Failed");

		}

		return upadteStatus;
	}

	public boolean deleteRecordByIdValidation(int id) throws ApplicationException {

		boolean data = false;
		if (String.valueOf(id).length() >= 5) {
			data=departmentDao.deleteRecordById(id);

		} else {
			throw new ApplicationException("Data Validation is Failed");

		}

		return data;
	}

}
