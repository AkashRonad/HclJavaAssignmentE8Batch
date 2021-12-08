package com.app.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.app.exception.ApplicationException;

public interface DatabaseConnection {

	public abstract Connection connectDB() throws ApplicationException;

	public abstract void disconnectDB(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet);

	public abstract void disconnectDB(Connection connection, PreparedStatement preparedStatement);

}
