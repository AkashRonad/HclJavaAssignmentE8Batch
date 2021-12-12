package com.app.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.app.exception.ApplicationException;
import com.app.module.Employee;
import com.app.util.HibernateUtil;
import com.app.util.HibernateUtilImpl;

public class EmployeeDaoImpl implements EmployeeDao {

	HibernateUtil hibernateUtil = new HibernateUtilImpl();

	@Override
	public boolean insertEmployeeRecord(Employee employee) throws ApplicationException {
		boolean data = false;
		SessionFactory sessionFactory = null;
		Session session = null;
		if (employee != null) {
			sessionFactory = hibernateUtil.getConnectionSession();
			session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			session.save(employee);
			transaction.commit();
			data = true;
		} else {
			throw new ApplicationException("Employee Object is Empty");
		}

		hibernateUtil.closeConnection(session, sessionFactory);

		return data;
	}

	@Override
	public Employee getEmployeeRecordById(int id) throws ApplicationException {
		Employee employee = null;
		SessionFactory sessionFactory = null;
		Session session = null;

		if (id > 0) {
			sessionFactory = hibernateUtil.getConnectionSession();
			session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			employee = (Employee) session.get(Employee.class, id);
			transaction.commit();

		} else {
			throw new ApplicationException("Given id Always Greater Than Zero");
		}

		hibernateUtil.closeConnection(session, sessionFactory);

		return employee;
	}

	@Override
	public List<Employee> getAllEmployees() throws ApplicationException {
		SessionFactory sessionFactory = null;
		Session session = null;
		sessionFactory = hibernateUtil.getConnectionSession();
		session = sessionFactory.openSession();
		List<Employee> employees = session.createSQLQuery("SELECT * FROM employeetable").addEntity(Employee.class)
				.list();

		if (employees.size() > 0) {

			return employees;
		} else {
			throw new ApplicationException("Employee Records Not Present In Table");
		}

	}

	@Override
	public boolean upadteEmployeeRecordById(int id, Employee employee) throws ApplicationException {
		boolean data = false;
		SessionFactory sessionFactory = null;
		Session session = null;
		if (id > 0 && employee != null) {
			sessionFactory = hibernateUtil.getConnectionSession();
			session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			Employee employee2 = (Employee) session.get(Employee.class, id);
			transaction.commit();
			if (employee2 != null) {
				session = sessionFactory.openSession();
				Transaction transaction1 = session.beginTransaction();
				session.update(employee);
				transaction1.commit();
				data = true;
			} else {
				throw new ApplicationException("Your Given Id Not Present In Database");
			}

		}

		hibernateUtil.closeConnection(session, sessionFactory);

		return data;
	}

	@Override
	public boolean deleteEmployeeRecordById(int id) throws ApplicationException {
		boolean data = false;
		SessionFactory sessionFactory = null;
		Session session = null;
		if (id > 0) {
			sessionFactory = hibernateUtil.getConnectionSession();
			session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			Employee employee2 = (Employee) session.get(Employee.class, id);
			transaction.commit();
			if (employee2 != null) {
				Transaction transaction1 = session.beginTransaction();
				session.delete(employee2);
				transaction1.commit();
				data = true;
			} else {
				throw new ApplicationException("Your Given Id Not Present In Database");
			}

		}
		hibernateUtil.closeConnection(session, sessionFactory);
		return data;
	}

}
