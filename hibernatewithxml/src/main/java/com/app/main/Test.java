package com.app.main;

import java.util.List;
import java.util.Scanner;

import com.app.exception.ApplicationException;
import com.app.module.Employee;
import com.app.service.EmployeeService;
import com.app.service.EmployeeServiceImpl;

public class Test {

	public static void main(String[] args) {

		System.out.println("Well Come Employee Dash Board");
		System.out.println("----------------------------------------------------------");
		Scanner sc = new Scanner(System.in);
		System.out.println(
				"\n Enter 1 for Insert Record ,\n Enter 2 for GetRecordByID,\n Enter 3 for  getAllEmployee\n Enter 4 for Update Record,\n Enter 5 for Delete Record");
		System.out.println("----------------------------------------------------------------------");

		int userInput = sc.nextInt();
		EmployeeService employeeService = new EmployeeServiceImpl();

		switch (userInput) {
		case 1:
			System.out.println("Enter Employee Id");
			int id = sc.nextInt();
			System.out.println("Enter Employee Name");
			String username = sc.next();
			System.out.println("Enter Employee Salary");
			double salary = sc.nextDouble();
			Employee employee = new Employee(id, username, salary);
			try {
				boolean insertStatus = employeeService.insertEmployeeRecordValidation(employee);
				if (insertStatus) {
					System.out.println("Employeee Record Inserted ");
				}

			} catch (ApplicationException e) {
				System.err.println(e.getMessage());

			}

			break;
		case 2:
			System.out.println("Enter Employee Id");
			int id_one = sc.nextInt();
			try {
				Employee employee_two = employeeService.getEmployeeRecordByIdValidation(id_one);
				if (employee_two != null) {
					System.out.println("Employee Name:" + employee_two.getName());
					System.out.println("Employee Salary " + employee_two.getSalary());
				}else {
					System.err.println("Employee Record Not Present In DB");
				}

			} catch (ApplicationException e) {
				System.err.println(e.getMessage());
			}
			break;
		case 3:
			try {
				List<Employee> employees = employeeService.getAllEmployees();
				for (Employee employee2 : employees) {
					System.out.println(employee2.getId());
					System.out.println(employee2.getName());
					System.out.println(employee2.getSalary());
					System.out.println("---------------------------------");

				}
			} catch (ApplicationException e) {
				System.err.println(e.getMessage());
			}

			break;

		case 4:
			System.out.println("Enter Employee Id");
			int id_three = sc.nextInt();
			System.out.println("Enter Employee UserName");
			String username_three = sc.next();
			System.out.println("Enter Employee Salary");
			double salary_three = sc.nextDouble();
			Employee employee_three = new Employee(id_three, username_three, salary_three);
			try {
				boolean upadteStatus = employeeService.upadteEmployeeRecordByIdValidation(id_three, employee_three);
				if (upadteStatus) {
					System.out.println("Employee Record is Upadted");
				} else {
					System.out.println("Employee Record is Not Upadted");
				}
			} catch (ApplicationException e) {
				System.err.println(e.getMessage());
			}
			break;

		case 5:
			System.out.println("Enter Employee Id");
			int id_four = sc.nextInt();
			try {
				boolean deleteStatus = employeeService.deleteEmployeeRecordByIdValidation(id_four);
				if (deleteStatus) {
					System.out.println("Employee Record Will Deleted");
				} else {
					System.out.println("Employee Record Will Not Deleted");
				}
			} catch (ApplicationException e) {
				System.err.println(e.getMessage());
			}
			break;

		default:
			break;
		}

		sc.close();

	}

}
