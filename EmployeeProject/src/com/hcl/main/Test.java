package com.hcl.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import com.hcl.module.Employee;
import com.hcl.service.EmployeeServiceImpl;

public class Test {

	public static void main(String[] args) throws FileNotFoundException, IOException {

		List<Employee> list = new ArrayList<Employee>();
		Properties prop = new Properties();
		prop.load(new FileInputStream("E:\\Intership Java Jdbc Program\\EmployeeProject\\src\\data.properties"));
		Employee employee = new Employee(prop.getProperty("name"), Integer.parseInt(prop.getProperty("id")),
				Float.parseFloat(prop.getProperty("salary")));
		Employee employee1 = new Employee(prop.getProperty("name_one"), Integer.parseInt(prop.getProperty("id_one")),
				Float.parseFloat(prop.getProperty("salary_one")));
		Employee employee2 = new Employee(prop.getProperty("name_two"), Integer.parseInt(prop.getProperty("id_two")),
				Float.parseFloat(prop.getProperty("salary_two")));
		Employee employee3 = new Employee(prop.getProperty("name_three"),
				Integer.parseInt(prop.getProperty("id_three")), Float.parseFloat(prop.getProperty("salary_three")));

		list.add(employee);
		list.add(employee1);
		list.add(employee2);
		list.add(employee3);

		EmployeeServiceImpl employeeServiceImpl = new EmployeeServiceImpl();
		List<Employee> resultlst = employeeServiceImpl.getAllEmployeesSalaryBased(list, 5000);

		Iterator<Employee> itr = resultlst.iterator();

		while (itr.hasNext()) {
			Employee result = (Employee) itr.next();
			System.out.println(result.getId());
			System.out.println(result.getName());
			System.out.println(result.getSalary());
			System.out.println("-----------------------");

		}

	}

}
