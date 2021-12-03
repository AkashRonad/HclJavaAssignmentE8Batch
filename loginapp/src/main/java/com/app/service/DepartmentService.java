package com.app.service;

import java.util.List;

import com.app.exception.ApplicationException;
import com.app.module.Department;

public interface DepartmentService {

	public abstract Department authenticateValidation(int userId, String password) throws ApplicationException;

}
