package com.app.model;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Book implements Serializable {

	private String isbn;

	private String year;

	@Autowired
	private Author author;

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

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

	public void setAuthor(Author author) {
		this.author = author;
	}

}
