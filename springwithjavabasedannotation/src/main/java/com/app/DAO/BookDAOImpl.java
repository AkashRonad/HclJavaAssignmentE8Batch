package com.app.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.exception.ApplicationException;
import com.app.model.Author;
import com.app.model.Book;

@Repository
public class BookDAOImpl implements BookDAO {

	@Autowired
	private Author author;
	@Autowired
	private Book book;

	@Override
	public Book authenticate(int userId, String password) throws ApplicationException {

		if (userId == 123456 && password.equals("@123456")) {

			author.setName("Sharanam Shah");
			author.setAddress("Gadag");
			book.setIsbn("978-93-5023-690-1");
			book.setYear("2019");
			book.setAuthor(author);

			book.setIsbn("978-93-5023-690");

		} else {
			throw new ApplicationException("Check Your User Name And Password");
		}

		return book;
	}

}
