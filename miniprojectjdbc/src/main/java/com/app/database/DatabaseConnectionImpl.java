package com.app.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.app.exception.ApplicationException;

public class DatabaseConnectionImpl implements DatabaseConnection {

	@Override
	public Connection connectDB() throws ApplicationException {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=2go14cs001");
		} catch (ClassNotFoundException | SQLException e) {
			throw new ApplicationException("Database Connection is Failed");

		}

		return connection;

	}

	@Override
	public void disconnectDB(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (preparedStatement != null) {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (connection != null) {

			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

	@Override
	public void disconnectDB(Connection connection, PreparedStatement preparedStatement) {

		if (preparedStatement != null) {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (connection != null) {

			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

}
