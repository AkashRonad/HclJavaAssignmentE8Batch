package com.app.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.app.exception.ApplicationException;

public class HibernateUtilImpl implements HibernateUtil {

	@Override
	public SessionFactory getConnectionSession() throws ApplicationException {
		SessionFactory sessionFactory = null;
		StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml")
				.build();
		Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();
		sessionFactory = metadata.getSessionFactoryBuilder().build();

		if (sessionFactory != null) {
			return sessionFactory;
		} else {
			throw new ApplicationException("SessionFactory Connection is Failed");
		}

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
