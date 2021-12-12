package com.app.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.app.exception.ApplicationException;

public interface HibernateUtil {

	public abstract SessionFactory getConnectionSession() throws ApplicationException;
	public abstract void closeConnection(Session session,SessionFactory sessionFactory);

}
