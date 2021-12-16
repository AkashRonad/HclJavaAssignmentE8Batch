package com.app.DAO;

import org.springframework.stereotype.Repository;

import com.app.exception.ApplicationException;
import com.app.model.Book;


public interface BookDAO {

	public abstract Book authenticate(int userId, String Password) throws ApplicationException;

}
