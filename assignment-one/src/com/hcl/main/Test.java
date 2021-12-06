package com.hcl.main;

import java.util.Scanner;

import com.hcl.module.Employee;

public class Test {

	public static int differenceBetweenTwoNumber(int num1, int num2) {

		int difference = 0;
		difference = num2 - num1;

		return difference;
	}

	public static boolean primeOrNot(int num1) {

		boolean prime = true;

		for (int i = 2; i < num1; i++) {
			int reminder = num1 % i;
			if (reminder == 0) {
				prime = false;
			}
		}

		return prime;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int increment = 1;

		// Question 1: Print Your Employee Details In Template
		Employee employee = new Employee(1, 25, "Akash Ronad", "Software Engineer", 9740152833L);

		System.out.println(employee);

		// Question 2 : Print Your Names 5 times using all loops (while, do while, for):

		while (increment <= 5) {
			System.out.println("Name of the employee" + ":" + employee.getName());
			increment++;
		}

		System.out.println("--------------------------------------------------------------------");
		increment = 1;
		do {

			System.out.println("Name of the employee" + ":" + employee.getName());
			increment++;

		} while (increment <= 5);

		System.out.println("---------------------------------------------------------------------------");
		for (int i = 0; i < 5; i++) {
			System.out.println("Details of the Employee" + ":" + employee);

		}

		System.out.println("-----------------------------------------------------------------------------");

		// Question 3 : write a program print difference between two numbers;
		System.out.println("Enter your First Number:");
		int number1 = sc.nextInt();
		System.out.println("Enter your Second Number:");
		int number2 = sc.nextInt();

		if (number1 > 0 && number2 > 0) {

			int difference = Test.differenceBetweenTwoNumber(number1, number2);

			System.out.println("Difference Between two number is" + ":" + difference);
		} else {
			System.out.println("Plz Provide Correct input Numbers");
		}

		System.out.println("-------------------------------------------------------------------------------------");

		// Question 4 : write a program check given number is prime or not;

		System.out.println("Enter your number :");
		int num1 = sc.nextInt();

		if (num1 > 0) {
			boolean prime = Test.primeOrNot(num1);

			if (prime) {
				System.out.println("Given number is Prime Number");
			} else {
				System.out.println("Given number is not Prime Number");
			}
		}

	}

}
