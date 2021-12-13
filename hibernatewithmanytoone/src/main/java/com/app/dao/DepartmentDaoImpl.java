package com.app.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.app.database.DatabaseConnection;
import com.app.database.DatabaseConnectionImpl;
import com.app.exception.ApplicationException;
import com.app.model.Deparment;
import com.app.model.Employee;

public class DepartmentDaoImpl implements DepartmentDao {

	DatabaseConnection databaseConnection = new DatabaseConnectionImpl();

	public boolean insertRecord(List<Employee> employees, Deparment deparment) throws ApplicationException {

		boolean data = false;
		SessionFactory sessionFactory = null;
		Session session = null;
		sessionFactory = databaseConnection.connect();
		if (sessionFactory != null) {
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			deparment.setEmployees(new ArrayList<Employee>());

			for (Employee employee : employees) {
				deparment.getEmployees().add(employee);

			}

			session.save(deparment);

			session.getTransaction().commit();
			data = true;

		} else {

			throw new ApplicationException("Connection is Failed");

		}

		databaseConnection.closeConnection(session, sessionFactory);

		return data;
	}

	public List<Employee> getAllRecords() throws ApplicationException {
		List<Employee> employees = null;
		SessionFactory sessionFactory = null;
		Session session = null;
		sessionFactory = databaseConnection.connect();
		if (sessionFactory != null) {
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			employees = session.createQuery("FROM Employee").list();
			session.getTransaction().commit();

		}

		databaseConnection.closeConnection(session, sessionFactory);

		return employees;
	}

	public boolean upadteInstructorRecordById(int id, Employee employee) throws ApplicationException {
		boolean data = false;
		SessionFactory sessionFactory = null;
		Session session = null;
		sessionFactory = databaseConnection.connect();
		if (sessionFactory != null) {
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			Employee employee_one = (Employee) session.get(Employee.class, id);
			employee_one.setFirstName(employee.getFirstName());
			employee_one.setLastName(employee.getLastName());
			employee_one.setPassword(employee.getPassword());
			session.update(employee_one);
			session.getTransaction().commit();

			data = true;

		} else {
			throw new ApplicationException("Connection is Failed");

		}

		databaseConnection.closeConnection(session, sessionFactory);
		return data;
	}

	public boolean deleteRecordById(int id) throws ApplicationException {
		boolean data = false;
		SessionFactory sessionFactory = null;
		Session session = null;
		sessionFactory = databaseConnection.connect();
		if (sessionFactory != null) {
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			Employee employee_one = (Employee) session.get(Employee.class, id);

			if (employee_one != null) {
				session.delete(employee_one);
				session.getTransaction().commit();
				data = true;
			}
		} else {
			throw new ApplicationException("Connection is Failed");

		}

		databaseConnection.closeConnection(session, sessionFactory);

		return data;
	}

}
