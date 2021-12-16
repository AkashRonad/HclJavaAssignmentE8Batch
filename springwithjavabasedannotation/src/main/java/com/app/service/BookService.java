package com.app.service;

import com.app.exception.ApplicationException;
import com.app.model.Book;

public interface BookService {
	public abstract Book authenticate(int userId, String Password) throws ApplicationException;

}
