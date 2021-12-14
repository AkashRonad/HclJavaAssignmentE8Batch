package com.app.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.app.model.Department;
import com.app.model.Employee;

public class Test {

	public static void main(String[] args) {

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("employee.xml");
		Department department = applicationContext.getBean("department", Department.class);
		System.out.println("------------------------------------------------------------------------");
		System.out.println("Department Id:=" + " " + department.getId());
		System.out.println("Department Name:=" + " " + department.getDname());

		System.out.println("------------------------------------------");
		List<Employee> employees = department.getEmployees();
		for (Employee employee : employees) {

			System.out.println("Employee id:= " + " " + employee.getId());
			System.out.println("Employee Name:= " + " " + employee.getName());
			System.out.println("Employee Salary:= " + " " + employee.getSalary());

			System.out.println("-----------------------------------------------------");

			System.out.println("Employee Address Pincode:= " + " " + employee.getAddress().getPincode());
			System.out.println("Employee Address Street:= " + " " + employee.getAddress().getStreet());
			System.out.println("Employee Address City:= " + " " + employee.getAddress().getCity());
			System.out
					.println("---------------------------------------------------------------------------------------");

		}

		((AbstractApplicationContext) applicationContext).close();
		System.out.println("End");

	}

}
