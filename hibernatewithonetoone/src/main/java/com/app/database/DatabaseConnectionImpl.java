package com.app.database;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.app.exception.ApplicationException;
import com.app.model.Instructor;
import com.app.model.InstructorDetail;

public class DatabaseConnectionImpl implements DatabaseConnection {

	@Override
	public SessionFactory connect() throws ApplicationException {
		SessionFactory sessionFactory = null;
		sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		return sessionFactory;
	}

	@Override
	public void closeConnection(Session session, SessionFactory sessionFactory) {
		if (sessionFactory != null) {
			sessionFactory.close();
		}

		if (session != null) {
			session.close();
		}

	}

}
