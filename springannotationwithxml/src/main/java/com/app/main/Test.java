package com.app.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.app.model.Book;

public class Test {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("annotation.xml");
		Book book = applicationContext.getBean("book", Book.class);
		System.out.println("Book ISBN" + book.getIsbn());
		System.out.println("Book Year" + book.getYear());
		System.out.println("------------------------------");
		System.out.println("Book author Name:" + book.getAuthor().getName());

//		// Exclude Filter And Include Filter
//		MessageService messageService = applicationContext.getBean("messageService", MessageService.class);
//		System.out.println(messageService);
	}

}
