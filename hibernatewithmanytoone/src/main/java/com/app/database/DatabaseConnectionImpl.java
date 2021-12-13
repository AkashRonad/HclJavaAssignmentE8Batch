package com.app.database;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.app.exception.ApplicationException;
import com.app.model.Deparment;
import com.app.model.Employee;

public class DatabaseConnectionImpl implements DatabaseConnection {

	public SessionFactory connect() throws ApplicationException {

		SessionFactory sessionFactory = null;
		sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.addAnnotatedClass(Deparment.class).buildSessionFactory();

		return sessionFactory;
	}

	public void closeConnection(Session session, SessionFactory sessionFactory) {

		if (sessionFactory != null) {
			sessionFactory.close();
		}

		if (session != null) {
			session.close();
		}

	}

}
