package com.app.dao;

import java.util.List;

import com.app.exception.ApplicationException;
import com.app.module.Employee;

public interface EmployeeDao {

	public abstract boolean insertEmployeeRecord(Employee employee) throws ApplicationException;

	public abstract Employee getEmployeeRecordById(int id) throws ApplicationException;

	public abstract List<Employee> getAllEmployees() throws ApplicationException;

	public abstract boolean upadteEmployeeRecordById(int id, Employee employee) throws ApplicationException;

	public abstract boolean deleteEmployeeRecordById(int id) throws ApplicationException;

}
