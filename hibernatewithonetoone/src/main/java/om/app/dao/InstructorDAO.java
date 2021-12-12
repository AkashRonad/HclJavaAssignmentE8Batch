package om.app.dao;

import java.util.List;

import com.app.exception.ApplicationException;
import com.app.model.Instructor;
import com.app.model.InstructorDetail;

public interface InstructorDAO {

	public abstract boolean insertInstructorRecord(Instructor instructor, InstructorDetail instructorDetail)
			throws ApplicationException;

	public abstract Instructor getInstructorRecordById(int id) throws ApplicationException;

	public abstract List<Instructor> getAllInstructor() throws ApplicationException;

	public abstract boolean upadteInstructorRecordById(int id, Instructor instructor,
			InstructorDetail instructorDetail) throws ApplicationException;
	
	public abstract boolean deleteInstructorRecordById(int id) throws ApplicationException;

}
