package com.app.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.app.exception.ApplicationException;
import com.app.model.Book;
import com.app.service.BookService;
import com.app.service.BookServiceImpl;

public class Test {

	public static void main(String[] args) {

		ApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.app");
		BookService bookService = new BookServiceImpl();
		try {
			Book book = bookService.authenticate(123456, "@123456");
			if (book != null) {
				System.out.println(book.getAuthor().getName());
			}
		} catch (ApplicationException e) {
			System.err.println(e.getMessage());
		}

	}

}
