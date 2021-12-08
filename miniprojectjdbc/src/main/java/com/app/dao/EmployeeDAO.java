package com.app.dao;

import com.app.exception.ApplicationException;
import com.app.module.Employee;

public interface EmployeeDAO {

	public abstract boolean insertEmployeeRecord(Employee employee) throws ApplicationException;

	public abstract Employee getEmployeeRecordById(int id) throws ApplicationException;

	public abstract Employee getEmployeeRecordByUsernameAndPassword(String username, String password)
			throws ApplicationException;

	public abstract boolean upadteEmployeeRecordById(int id, Employee employee) throws ApplicationException;

	public abstract boolean deleteEmployeeRecordById(int id) throws ApplicationException;

	public abstract boolean checkBeforeStoredDataIntoDB(Employee employee) throws ApplicationException;

}
