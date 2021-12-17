package om.app.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.app.config.DemoConfig;
import com.app.exception.ApplicationException;
import com.app.model.Student;
import com.app.service.StudentService;

public class Test {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		StudentService studentService = context.getBean("studentService", StudentService.class);
		Student student = new Student();
		try {
			student = studentService.getStudentByIdValidation(student);
			if (student != null) {
				System.out.println(student.getId());
				System.out.println(student.getName());
			}
		} catch (ApplicationException e) {
			System.err.println(e.getMessage());
		}

		context.close();

	}

}
