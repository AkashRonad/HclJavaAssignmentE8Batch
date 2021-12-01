package com.hcl.service;

import java.util.List;

import com.hcl.module.Employee;

public interface EmployeeService {

	public abstract List<Employee> getAllEmployeesSalaryBased(List<Employee> list, float salary);

}
