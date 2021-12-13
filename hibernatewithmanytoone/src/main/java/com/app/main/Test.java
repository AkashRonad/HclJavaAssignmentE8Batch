package com.app.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.app.exception.ApplicationException;
import com.app.model.Deparment;
import com.app.model.Employee;
import com.app.service.DeparmentService;
import com.app.service.DepartmentServiceImpl;

public class Test {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println(
				"\n Enter 1 for Insert Record ,\n Enter 2 for  getAllRecords\n Enter 3 for Update Record,\n Enter 4 for Delete Record");
		System.out.println("----------------------------------------------------------------------");

		int userInput = scanner.nextInt();
		DeparmentService deparmentService = new DepartmentServiceImpl();
		switch (userInput) {
		case 1:
			List<Employee> employees = new ArrayList<Employee>();
			System.out.println("How many Employeee You Want to Insert ?");
			int sizeOfEmployee = scanner.nextInt();

			for (int i = 1; i <= sizeOfEmployee; i++) {
				System.out.println("Enter Your Employee Id");
				int id = scanner.nextInt();
				System.out.println("Enter Your Employee FirstName");
				String firstName = scanner.next();
				System.out.println("Enter Your Employee LastName");
				String lastname = scanner.next();
				System.out.println("Enter your password");
				String password = scanner.next();
				Employee employee = new Employee(id, firstName, lastname, password);
				employees.add(employee);

			}

			System.out.println("Enter Department Name");
			String departmentName = scanner.next();
			Deparment deparment = new Deparment(departmentName);
			try {
				boolean data = deparmentService.insertRecordValiadtion(employees, deparment);
				if (data) {
					System.out.println("Data Is Stored");
				} else {
					System.out.println("Data Is not Stored");
				}
			} catch (ApplicationException e) {
				System.err.println(e.getMessage());
			}

			break;

		case 2:

			try {
				List<Employee> employees_one = deparmentService.getAllRecords();
				if (employees_one.size() > 0) {
					for (Employee employee : employees_one) {

						System.out.println("Employee Id:" + employee.getId());
						System.out.println(
								"Employee FUll Name:" + employee.getFirstName() + " " + employee.getLastName());
						System.out.println("Department Id " + employee.getDeparment().getId());
						System.out.println("Department Name:" + employee.getDeparment().getName());

					}
				}
			} catch (ApplicationException e) {
				System.out.println(e.getMessage());
			}
			break;

		case 3:

			System.out.println("Enter Your Employee Id");
			int id = scanner.nextInt();
			System.out.println("Enter Your Employee FirstName");
			String firstName = scanner.next();
			System.out.println("Enter Your Employee LastName");
			String lastname = scanner.next();
			System.out.println("Enter your password");
			String password = scanner.next();

			Employee employee = new Employee(id, firstName, lastname, password);

			try {
				boolean data = deparmentService.upadteInstructorRecordByIdValidation(id, employee);
				if (data) {
					System.out.println("Record is Upadted");
				} else {
					System.out.println("Record is not Upadted");
				}
			} catch (ApplicationException e) {
				System.err.println(e.getMessage());
			}

			break;

		case 4:
			System.out.println("Enter Your Employee Id");
			int id_one = scanner.nextInt();
			try {
				boolean data = deparmentService.deleteRecordByIdValidation(id_one);
				if (data) {
					System.out.println("Record is Deleted");
				} else {
					System.out.println("Record is Not Deleted");
				}
			} catch (ApplicationException e) {
				System.err.println(e.getMessage());
			}

			break;

		default:
			break;
		}

		scanner.close();

	}
}
