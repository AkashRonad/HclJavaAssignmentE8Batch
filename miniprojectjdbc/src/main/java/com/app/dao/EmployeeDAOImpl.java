package com.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;

import com.app.database.DatabaseConnection;
import com.app.database.DatabaseConnectionImpl;
import com.app.exception.ApplicationException;
import com.app.module.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {

	DatabaseConnection databaseConnection = new DatabaseConnectionImpl();

	@Override
	public boolean checkBeforeStoredDataIntoDB(Employee employee) throws ApplicationException {

		boolean data = true;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String selectQry = "SELECT * FROM el18h.employee WHERE id=? AND username=? AND password=?";
		connection = databaseConnection.connectDB();

		if (employee != null && connection != null) {
			try {
				preparedStatement = connection.prepareStatement(selectQry);
				preparedStatement.setInt(1, employee.getId());
				preparedStatement.setString(2, employee.getUsername());
				String basicBaseFormat = Base64.getEncoder().encodeToString(employee.getPassword().getBytes());
				preparedStatement.setString(3, basicBaseFormat);
				resultSet = preparedStatement.executeQuery();
				if (resultSet.next()) {
					data = false;
				}

			} catch (SQLException e) {

				e.printStackTrace();
			}

			databaseConnection.disconnectDB(connection, preparedStatement, resultSet);

		} else {
			throw new ApplicationException("Check Object Data and Db connection");
		}

		return data;
	}

	@Override
	public boolean insertEmployeeRecord(Employee employee) throws ApplicationException {
		boolean insertStatus = false;

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String insertQry = "INSERT INTO el18h.employee (id,username,password) VALUES (?,?,?)";
		connection = databaseConnection.connectDB();
		if (employee != null && connection != null) {
			try {
				boolean data = this.checkBeforeStoredDataIntoDB(employee);
				if (data) {
					preparedStatement = connection.prepareStatement(insertQry);
					preparedStatement.setInt(1, employee.getId());
					preparedStatement.setString(2, employee.getUsername());
					String basicBaseFormat = Base64.getEncoder().encodeToString(employee.getPassword().getBytes());
					preparedStatement.setString(3, basicBaseFormat);
					int numberofRowsAffected = preparedStatement.executeUpdate();
					if (numberofRowsAffected > 0) {
						insertStatus = true;
					}

				} else {
					throw new ApplicationException("Employee Details Aleredy Present in DB");
				}

			} catch (ApplicationException | SQLException applicationException) {
				applicationException.printStackTrace();
			}

		}

		databaseConnection.disconnectDB(connection, preparedStatement);

		return insertStatus;
	}

	@Override
	public Employee getEmployeeRecordById(int id) throws ApplicationException {
		Employee employee = new Employee();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String selectQry = "SELECT * FROM el18h.employee WHERE id=?";
		connection = databaseConnection.connectDB();

		if (connection != null) {
			try {
				preparedStatement = connection.prepareStatement(selectQry);
				preparedStatement.setInt(1, id);
				resultSet = preparedStatement.executeQuery();
				if (resultSet.next()) {
					byte[] actualBytePassword = Base64.getDecoder().decode(resultSet.getString(3));
					String actualPassword = new String(actualBytePassword);
					employee.setUsername(resultSet.getString(2));
					employee.setPassword(actualPassword);
					employee.setId(resultSet.getInt(1));

				} else {
					throw new ApplicationException("Employee Record Not Fteched Using ID");

				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			throw new ApplicationException(" Database Connection Failed");
		}

		databaseConnection.disconnectDB(connection, preparedStatement, resultSet);

		return employee;
	}

	@Override
	public Employee getEmployeeRecordByUsernameAndPassword(String username, String password)
			throws ApplicationException {
		Employee employee = new Employee();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String selectQry = "SELECT * FROM el18h.employee WHERE username=? AND password=?";
		connection = databaseConnection.connectDB();

		if (connection != null) {
			try {
				preparedStatement = connection.prepareStatement(selectQry);
				String basicBaseFormat = Base64.getEncoder().encodeToString(password.getBytes());
				preparedStatement.setString(1, username);
				preparedStatement.setString(2, basicBaseFormat);
				resultSet = preparedStatement.executeQuery();
				if (resultSet.next()) {
					byte[] actualBytePassword = Base64.getDecoder().decode(resultSet.getString(3));
					String actualPassword = new String(actualBytePassword);
					employee.setUsername(resultSet.getString(2));
					employee.setPassword(actualPassword);
					employee.setId(resultSet.getInt(1));

				} else {
					throw new ApplicationException("Employee Record Not Fteched Using Username And Password");

				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			throw new ApplicationException(" Database Connection Failed");
		}

		databaseConnection.disconnectDB(connection, preparedStatement, resultSet);

		return employee;
	}

	@Override
	public boolean upadteEmployeeRecordById(int id, Employee employee) throws ApplicationException {
		boolean upadteStatus = false;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String upadteQry = "UPDATE el18h.employee SET username=?,password=? WHERE id=?";
		connection = databaseConnection.connectDB();

		if (connection != null) {
			try {
				preparedStatement = connection.prepareStatement(upadteQry);
				preparedStatement.setString(1, employee.getUsername());
				String basicBaseFormat = Base64.getEncoder().encodeToString(employee.getPassword().getBytes());
				preparedStatement.setString(2, basicBaseFormat);
				preparedStatement.setInt(3, id);

				int numberofUpadteRecord = preparedStatement.executeUpdate();
				if (numberofUpadteRecord > 0) {
					upadteStatus = true;
				} else {
					throw new ApplicationException("Employee Details Not Upadted");
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			throw new ApplicationException(" Database Connection Failed");

		}

		databaseConnection.disconnectDB(connection, preparedStatement);
		return upadteStatus;
	}

	@Override
	public boolean deleteEmployeeRecordById(int id) throws ApplicationException {
		boolean deleteStatus = false;

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String deleteQry = "DELETE FROM el18h.employee WHERE id=?";
		connection = databaseConnection.connectDB();

		if (connection != null) {
			try {
				preparedStatement = connection.prepareStatement(deleteQry);
				preparedStatement.setInt(1, id);
				int numberofDeletedRecord = preparedStatement.executeUpdate();
				if (numberofDeletedRecord > 0) {
					deleteStatus = true;
				} else {
					throw new ApplicationException("Employee Details Not Deleted");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} else {
			throw new ApplicationException(" Database Connection Failed");

		}
		databaseConnection.disconnectDB(connection, preparedStatement);
		return deleteStatus;
	}

}
