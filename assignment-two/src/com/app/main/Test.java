package com.app.main;

import com.app.methods.AllMethods;
import com.app.module.Employee;

public class Test {

	public static void main(String[] args) {
		// Question 1: Create a array and print the data
		int data[] = AllMethods.storedData();
		System.out.println("---------------------------------------------");
		AllMethods.displayArrayNumbers(data);
		System.out.println("------------------------------------------------");

		// Question 2: Create a array and sum of all the data

		int sum = AllMethods.sumOfAllArrayElements(data);
		System.out.println("Sum of array Elements is:" + sum);

		System.out.println("---------------------------------------------");

		// Question 3: Create a array and reverse of all the data
		AllMethods.reverseArrayElements(data);
		System.out.println("-------------------------------------------------");

		// Question 4: Create 2 employee details and Display the data

		Employee employees[] = new Employee[2];
		Employee employee2 = new Employee(1, "Akash Ronad", 30000f);
		Employee employee3 = new Employee(2, "Arun", 40000f);
		employees[0] = employee2;
		employees[1] = employee3;

		for (int i = 0; i < employees.length; i++) {
			Employee employee4 = employees[i];
			System.out.println(employee4);

		}

		System.out.println("-------------------------------------------------");

		// Question 5: Create 2 employee details and calculate the total salary

		float sumofSalary = AllMethods.calculateTotalSalary(employees);
		System.out.println("Sum of two Employee Salary is" + ":" + sumofSalary);

		System.out.println("--------------------------------------------------------------------");

		// Question 6 : Find the length of all employees names write the method

		int lengthOfEmployessNames[] = AllMethods.findEachEmployeeNameLength(employees);
		AllMethods.displayArrayNumbers(lengthOfEmployessNames);

		System.out.println("--------------------------------------------------------------------");

		// Question 7 : Find the Total and Average of Employees Salary
		System.out.println("Sum of Total Employee Salray is" + sumofSalary);
		System.out.println("Average of Employee Salary is: " + sumofSalary / employees.length);

		System.out.println("---------------------------------------------------------------------------");
		// Question 8 : Find Employee Details based On id
		Employee employee = AllMethods.retriveEmployeeDetailsBasedOnId(1, employees);
		System.out.println(employee);

	}

}
