package om.app.dao;

import com.app.model.Student;

@FunctionalInterface
public interface EmployeeService {

	public abstract Student print(int id, String name, int age);

}
