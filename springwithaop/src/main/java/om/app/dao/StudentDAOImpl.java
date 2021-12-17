package om.app.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.model.Student;

@Repository
public class StudentDAOImpl implements StudentDAO {

	@Autowired
	Student student;

	@Override
	public Student getStudentById(Student student) {
		student.setName(student.getName().toUpperCase());
		
		return student;
	}

}
