package com.app.service;

import java.util.List;

import com.app.exception.ApplicationException;
import com.app.model.Instructor;
import com.app.model.InstructorDetail;

import om.app.dao.InstructorDAO;
import om.app.dao.InstructorDAOImpl;

public class InstructorServiceImpl implements InstructorService {

	InstructorDAO instructorDAO = new InstructorDAOImpl();

	@Override
	public boolean insertInstructorRecordValidation(Instructor instructor, InstructorDetail instructorDetail)
			throws ApplicationException {
		boolean insertStatus = false;
		if (instructor != null && instructorDetail != null) {
			insertStatus = instructorDAO.insertInstructorRecord(instructor, instructorDetail);

		} else {

			throw new ApplicationException("Data Validation is Failed");

		}

		return insertStatus;
	}

	@Override
	public Instructor getInstructorRecordByIdValidation(int id) throws ApplicationException {
		Instructor instructor = null;
		if (id > 0) {
			instructor = instructorDAO.getInstructorRecordById(id);

		} else {
			throw new ApplicationException("Data Validation is Failed");
		}
		return instructor;
	}

	@Override
	public List<Instructor> getAllInstructor() throws ApplicationException {
		List<Instructor> instructors = instructorDAO.getAllInstructor();
		return instructors;
	}

	@Override
	public boolean upadteInstructorRecordByIdValidation(int id, Instructor instructor,
			InstructorDetail instructorDetail) throws ApplicationException {
		boolean upadteStatus = false;

		if (id > 0 && instructor != null && instructorDetail != null) {
			upadteStatus = instructorDAO.upadteInstructorRecordById(id, instructor, instructorDetail);

		} else {
			throw new ApplicationException("Data Validation is Failed");

		}

		return upadteStatus;
	}

	@Override
	public boolean deleteInstructorRecordByIdValidation(int id) throws ApplicationException {
		boolean deleteStatus=false;
		
		if(id>0) {
			deleteStatus=instructorDAO.deleteInstructorRecordById(id);
			
		}else {
			throw new ApplicationException("Data Validation is Failed");
			
		}

		return deleteStatus;
	}

}
