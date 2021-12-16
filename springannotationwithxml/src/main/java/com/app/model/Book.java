package com.app.model;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Book implements Serializable {

	@Value("12345678")
	private String isbn;
	@Value("2019")
	private String year;

	// 1 Dependency Checking Using required field Using Autowired
	// 2 Qualifying --Sometimes it may happen that there are two or more beans each
	// of
	// which equally qualifies to be wired into be wired into property
	// @Autowired(required = false)
	// @Qualifier("author1")
	@Autowired
	private Author author;

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	// @Autowired
	public Book(Author author) {
		this.author = author;
	}

	public Book(String isbn, String year) {
		super();
		this.isbn = isbn;
		this.year = year;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public Author getAuthor() {
		return author;
	}

	// @Autowired
	// @Required
	public void setAuthor(Author author) {
		this.author = author;
	}

}
