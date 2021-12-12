package com.app.database;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.app.exception.ApplicationException;

public interface DatabaseConnection {

	public abstract SessionFactory connect() throws ApplicationException;

	public abstract void closeConnection(Session session, SessionFactory sessionFactory);
	

}
