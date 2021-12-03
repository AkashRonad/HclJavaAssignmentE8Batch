package com.app.service;

import com.app.dao.DepartmentDao;
import com.app.dao.DepartmentDaoImpl;
import com.app.exception.ApplicationException;
import com.app.module.Department;

public class DepartmentServiceImpl implements DepartmentService {

	@Override
	public Department authenticateValidation(int userId, String password) throws ApplicationException {
		Department department = null;
		int userIdLength = String.valueOf(userId).length();
		int passwordLength = password.length();
		if (userId != -1 && password != null && userIdLength >= 5 && passwordLength >= 5) {

			DepartmentDao departmentDao = new DepartmentDaoImpl();
			department = departmentDao.authenticateDao(userId, password);

		} else {

			throw new ApplicationException("User Data Invalidate");

		}
		return department;
	}

}
