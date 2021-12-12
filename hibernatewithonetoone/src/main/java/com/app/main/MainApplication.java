package com.app.main;

import java.util.List;
import java.util.Scanner;

import com.app.exception.ApplicationException;
import com.app.model.Instructor;
import com.app.model.InstructorDetail;
import com.app.service.InstructorService;
import com.app.service.InstructorServiceImpl;

public class MainApplication {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println(
				"\n Enter 1 for Insert Record ,\n Enter 2 for GetRecordByID,\n Enter 3 for  getAllInstructor\n Enter 4 for Update Record,\n Enter 5 for Delete Record");
		System.out.println("----------------------------------------------------------------------");

		int userInput = scanner.nextInt();
		InstructorService instructorService = new InstructorServiceImpl();

		switch (userInput) {
		case 1:
			System.out.println("Enter Your First Name");
			String firstName = scanner.next();
			System.out.println("Enter Your Last Name");
			String lastName = scanner.next();
			System.out.println("Enter Your Email Id");
			String email = scanner.next();
			System.out.println(" Enter Your YoutubeChannel Name ");
			String youTubeChannelName = scanner.next();
			System.out.println("Enter Your Hobby");
			String hobby = scanner.next();

			InstructorDetail instructorDetail = new InstructorDetail(youTubeChannelName, hobby);
			Instructor instructor = new Instructor(firstName, lastName, email);

			try {
				boolean insertStatus = instructorService.insertInstructorRecordValidation(instructor, instructorDetail);
				if (insertStatus) {
					System.out.println("Record Saved");
				} else {
					System.out.println("Record Not Saved");
				}
			} catch (ApplicationException e) {
				System.err.println(e.getMessage());
			}

			break;
		case 2:
			System.out.println("Enter id");
			int id = scanner.nextInt();
			try {
				Instructor instructor_one = instructorService.getInstructorRecordByIdValidation(id);
				if (instructor_one != null) {
					System.out.println(instructor_one);
					System.out.println(instructor_one.getInstructorDetail());
				}
			} catch (ApplicationException e) {
				System.err.println(e.getMessage());
			}

			break;
		case 3:
			try {
				List<Instructor> instructors = instructorService.getAllInstructor();
				if (instructors.size() > 0) {
					for (Instructor instructor2 : instructors) {
						System.out.println(instructor2);

					}
				}
			} catch (ApplicationException e) {
				System.err.println(e.getMessage());
			}
			break;

		case 4:
			System.out.println("Enter Your id");
			int idOne = scanner.nextInt();

			System.out.println("Enter Your First Name");
			String firstNameOne = scanner.next();
			System.out.println("Enter Your Last Name");
			String lastNameOne = scanner.next();
			System.out.println("Enter Your Email Id");
			String emailOne = scanner.next();
			System.out.println(" Enter Your YoutubeChannel Name ");
			String youTubeChannelNameOne = scanner.next();
			System.out.println("Enter Your Hobby");
			String hobbyOne = scanner.next();

			InstructorDetail instructorDetailOne = new InstructorDetail(youTubeChannelNameOne, hobbyOne);
			Instructor instructorOne = new Instructor(firstNameOne, lastNameOne, emailOne);
			try {
				boolean updateStatus = instructorService.upadteInstructorRecordByIdValidation(idOne, instructorOne,
						instructorDetailOne);
				if (updateStatus) {
					System.out.println("Upadted Record");
				} else {
					System.out.println("Not Upadted Record");

				}

			} catch (ApplicationException e) {
				System.err.println(e.getMessage());

			}

			break;
		case 5:
			System.out.println("Enter Id");
			int id_two = scanner.nextInt();
			try {
				boolean deleteStatus = instructorService.deleteInstructorRecordByIdValidation(id_two);
				if (deleteStatus) {
					System.out.println("Data Deleted");
				} else {
					System.out.println("Data not Deleted");
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
