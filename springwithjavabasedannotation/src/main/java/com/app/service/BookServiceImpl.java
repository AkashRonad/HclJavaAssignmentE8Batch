package com.app.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import com.app.DAO.BookDAOImpl;
import com.app.exception.ApplicationException;
import com.app.model.Book;

@Service
public class BookServiceImpl implements BookService {

	public BookServiceImpl() {

	}

	@Override
	public Book authenticate(int userId, String password) throws ApplicationException {
		Book book = null;
		if (String.valueOf(userId).length() >= 5 && password.length() >= 5) {
			ApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.app");
			BookDAOImpl bookDAOImpl = applicationContext.getBean("bookDAOImpl", BookDAOImpl.class);
			book = bookDAOImpl.authenticate(userId, password);

		} else {
			throw new ApplicationException("Data Validation Is Failed");
		}

		return book;
	}

}
