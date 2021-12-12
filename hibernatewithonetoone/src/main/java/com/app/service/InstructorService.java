package com.app.service;

import java.util.List;

import com.app.exception.ApplicationException;
import com.app.model.Instructor;
import com.app.model.InstructorDetail;

public interface InstructorService {

	public abstract boolean insertInstructorRecordValidation(Instructor instructor, InstructorDetail instructorDetail)
			throws ApplicationException;

	public abstract Instructor getInstructorRecordByIdValidation(int id) throws ApplicationException;

	public abstract List<Instructor> getAllInstructor() throws ApplicationException;

	public abstract boolean upadteInstructorRecordByIdValidation(int id, Instructor instructor,
			InstructorDetail instructorDetail) throws ApplicationException;

	public abstract boolean deleteInstructorRecordByIdValidation(int id) throws ApplicationException;

}
