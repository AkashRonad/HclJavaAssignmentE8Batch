package om.app.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.app.database.DatabaseConnection;
import com.app.database.DatabaseConnectionImpl;
import com.app.exception.ApplicationException;
import com.app.model.Instructor;
import com.app.model.InstructorDetail;

public class InstructorDAOImpl implements InstructorDAO {

	DatabaseConnection databaseConnection = new DatabaseConnectionImpl();

	@Override
	public boolean insertInstructorRecord(Instructor instructor, InstructorDetail instructorDetail)
			throws ApplicationException {
		SessionFactory sessionFactory = null;
		Session session = null;
		boolean data = false;

		sessionFactory = databaseConnection.connect();
		if (sessionFactory != null) {
			session = sessionFactory.getCurrentSession();
			instructor.setInstructorDetail(instructorDetail);
			session.beginTransaction();
			session.save(instructor);
			session.getTransaction().commit();
			data = true;
		} else {
			throw new ApplicationException("Database Connection Is Failed");
		}

		databaseConnection.closeConnection(session, sessionFactory);

		return data;
	}

	@Override
	public Instructor getInstructorRecordById(int id) throws ApplicationException {
		Instructor instructor = null;
		SessionFactory sessionFactory = null;
		Session session = null;
		sessionFactory = databaseConnection.connect();
		if (sessionFactory != null) {
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			instructor = (Instructor) session.get(Instructor.class, id);
			session.getTransaction().commit();

		} else {
			throw new ApplicationException("Database Connection Is Failed");
		}

		databaseConnection.closeConnection(session, sessionFactory);

		return instructor;
	}

	@Override
	public List<Instructor> getAllInstructor() throws ApplicationException {
		List<Instructor> instructors = null;
		SessionFactory sessionFactory = null;
		Session session = null;
		sessionFactory = databaseConnection.connect();

		if (sessionFactory != null) {
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			instructors = session.createSQLQuery("SELECT * FROM instructor").addEntity(Instructor.class).list();
			session.getTransaction().commit();

		} else {
			throw new ApplicationException("Database Connection Is Failed");

		}

		return instructors;
	}

	@Override
	public boolean upadteInstructorRecordById(int id, Instructor instructor, InstructorDetail instructorDetail)
			throws ApplicationException {

		boolean data = false;
		SessionFactory sessionFactory = null;
		Session session = null;
		sessionFactory = databaseConnection.connect();
		session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Instructor instructor_two = (Instructor) session.get(Instructor.class, id);
		session.getTransaction().commit();
		instructor_two.setFirstname(instructor.getFirstname());
		instructor_two.setLastname(instructor.getLastname());
		instructor_two.setEmail(instructor.getEmail());
		instructor_two.setInstructorDetail(instructorDetail);

		if (sessionFactory != null && instructor_two != null) {
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			session.update(instructor_two);
			session.getTransaction().commit();
			data = true;

		} else {
			throw new ApplicationException("Database Connection Is Failed");

		}

		return data;
	}

	@Override
	public boolean deleteInstructorRecordById(int id) throws ApplicationException {
		boolean data = false;
		SessionFactory sessionFactory = null;
		Session session = null;
		sessionFactory = databaseConnection.connect();
		if (sessionFactory != null) {
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			Instructor instructor = (Instructor) session.get(Instructor.class, id);
			session.getTransaction().commit();

			if (instructor != null) {
				session = sessionFactory.getCurrentSession();
				session.beginTransaction();
				session.delete(instructor);
				session.getTransaction().commit();
				data = true;
			} else {
				throw new ApplicationException("Id Not Present In DataBase");

			}

		} else {
			throw new ApplicationException("Database Connection Is Failed");

		}

		return data;
	}

}
