package com.app.dao;

import java.util.ArrayList;
import java.util.List;

import com.app.exception.ApplicationException;
import com.app.module.Department;
import com.app.module.Employee;

public class DepartmentDaoImpl implements DepartmentDao {

	public List<Department> init() {

		Department department = new Department(1, "CSE", new Employee(11111, "Akash", "Akash123"));
		Department department1 = new Department(2, "ENC", new Employee(22222, "Arun", "Arun123"));
		Department department2 = new Department(1, "CSE", new Employee(33333, "Laxmi", "Laxmi123"));
		Department department3 = new Department(3, "EC", new Employee(44444, "Guru", "Guru123"));
		List<Department> departmentList = new ArrayList<Department>();
		departmentList.add(department);
		departmentList.add(department1);
		departmentList.add(department2);
		departmentList.add(department3);

		return departmentList;
	}

	@Override
	public Department authenticateDao(int userId, String password) throws ApplicationException {

		List<Department> departments = this.init();
		Department departmentResult = null;
		if (departments.size() > 0) {

			for (Department department : departments) {

				if (department.getEmployee().getEmployeeUserId() == userId
						&& department.getEmployee().getEmployeePassword().equals(password)) {

					departmentResult = department;

				}

			}

		}

		if (departmentResult != null) {

			return departmentResult;

		} else {

			throw new ApplicationException("No Such User");

		}

	}

}
