package com.hcl.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.hcl.module.Employee;

public class EmployeeServiceImpl implements EmployeeService {

	@Override
	public List<Employee> getAllEmployeesSalaryBased(List<Employee> list, float salary) {

		List<Employee> lst = new ArrayList<Employee>();

		Iterator<Employee> itr = list.iterator();

		while (itr.hasNext()) {
			Employee employee = (Employee) itr.next();
			if (employee.getSalary() >= salary) {
				lst.add(employee);
			}
		}

		return lst;
	}

}
