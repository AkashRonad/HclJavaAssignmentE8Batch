package com.app.dao;

import com.app.exception.ApplicationException;
import com.app.module.Department;

public interface DepartmentDao {
	public abstract Department authenticateDao(int userId, String password) throws ApplicationException;

}
