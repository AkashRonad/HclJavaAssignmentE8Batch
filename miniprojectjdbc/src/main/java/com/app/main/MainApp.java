package com.app.main;

import java.util.Scanner;

import com.app.exception.ApplicationException;
import com.app.module.Employee;
import com.app.service.EmployeeService;
import com.app.service.EmployeeServiceImpl;

public class MainApp {

	public static void main(String[] args) {
		System.out.println("Well Come Employee Dash Board");
		System.out.println("----------------------------------------------------------");
		Scanner sc = new Scanner(System.in);
		System.out.println(
				"\n Enter 1 for Insert Record ,\n Enter 2 for GetRecordByID,\n Enter 3 for GetRecordByUsernameAndPassword,\n Enter 4 for Update Record,\n Enter 5 for Delete Record");
		System.out.println("----------------------------------------------------------------------");

		int userInput = sc.nextInt();
		EmployeeService employeeService = new EmployeeServiceImpl();

		switch (userInput) {
		case 1:
			System.out.println("Enter Employee Id");
			int id = sc.nextInt();
			System.out.println("Enter Employee UserName");
			String username = sc.next();
			System.out.println("Enter Employee Password");
			String password = sc.next();
			Employee employee = new Employee(id, username, password);
			try {
				boolean insertStatus = employeeService.insertEmployeeRecordValidation(employee);
				if (insertStatus) {
					System.out.println("Employee Record Is Inserted");
				} else {
					System.out.println("Employee Record not Inserted");
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
					System.out.println("Employee Username" + " " + employee_two.getUsername());
					System.out.println("Employee Password" + " " + employee_two.getPassword());
				}
			} catch (ApplicationException e) {
				System.err.println(e.getMessage());
			}

			break;

		case 3:
			System.out.println("Enter Employee UserName");
			String username_one = sc.next();
			System.out.println("Enter Employee Password");
			String password_one = sc.next();
			try {
				Employee employee_two = employeeService.getEmployeeRecordByUsernameAndPasswordValidation(username_one,
						password_one);

				if (employee_two != null) {
					System.out.println("Employee Id " + employee_two.getId());
					System.out.println("Employee Username" + " " + employee_two.getUsername());
					System.out.println("Employee Password" + " " + employee_two.getPassword());

				}
			} catch (ApplicationException e) {

				e.printStackTrace();
			}

			break;

		case 4:
			System.out.println("Enter Employee Id");
			int id_three = sc.nextInt();
			System.out.println("Enter Employee UserName");
			String username_three = sc.next();
			System.out.println("Enter Employee Password");
			String password_three = sc.next();
			Employee employee_three = new Employee(id_three, username_three, password_three);
			try {
				boolean upadteStatus = employeeService.upadteEmployeeRecordByIdValidate(id_three, employee_three);
				if (upadteStatus) {
					System.out.println("Employee Recored Upadate  Sucessfully");
				} else {
					System.out.println("Employee Recored Not Upadted ");
				}
			} catch (ApplicationException e) {
				System.err.println(e.getMessage());
			}
			break;
		case 5:
			System.out.println("Enter Employee Id");
			int id_four = sc.nextInt();
			try {
				boolean deleteRecordStatus = employeeService.deleteEmployeeRecordByIdValidate(id_four);
				if (deleteRecordStatus) {
					System.out.println("Employee Record Deleted");
				} else {
					System.out.println("Employee Record not Deleted");

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
