package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Employee;

public class DaoImplJDBC implements Dao{

	private Connection connection;
	
	@Override
	public void connect() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/Shop";
		String user = "root";
		String pass = "";
		this.connection = DriverManager.getConnection(url, user, pass);
	}

	@Override
	public Employee getEmployee(int employeeId, String password) {
		Employee employee = null;
		String query = "SELECT employeeId, name, password FROM employee WHERE employeeId = ? AND password = ?";
		
		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, employeeId);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int id = resultSet.getInt("employeeId");
                String employeeName = resultSet.getString("name");

                employee = new Employee(employeeName, id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return employee;
	}

	@Override
	public void disconnect() throws SQLException{
		if (connection != null) {
			connection.close();
		}
	}
	
}
