package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import model.Employee;
import model.Product;

public class DaoImplFile implements Dao{

	@Override
	public void connect() throws SQLException {
		
	}

	@Override
	public Employee getEmployee(int employeeId, String password) {
		return null;
	}

	@Override
	public void disconnect() throws SQLException {
		
	}

	@Override
	public ArrayList<Product> getInventory() {
		return null;
	}

	@Override
	public boolean writeInventory(ArrayList<Product> inventory) {
		return false;
	}

	
}
