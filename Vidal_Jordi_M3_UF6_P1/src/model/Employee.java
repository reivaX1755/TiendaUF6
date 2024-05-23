package model;

import java.sql.SQLException;

import dao.Dao;
import dao.DaoImplJDBC;
import main.Logable;

public class Employee extends Person implements Logable{
	
	int employeeID;
	Dao dao;
	//final static int USER = 123;
	//final static String PASSWORD = "test";
	
	public Employee(String name, int employeeID) {
		super(name);
		this.employeeID = employeeID;
		this.dao = new DaoImplJDBC();
	}
	@Override
	public boolean login(int user, String password) {
        boolean isLogged = false;
        try {
			dao.connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
        Employee employeeConsulta = dao.getEmployee(employeeID, password);
        if(employeeConsulta != null) {
        	isLogged = true;
        }
        try {
			dao.disconnect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return isLogged;
        //if (user == USER && password.equals(PASSWORD)) { isLogged = true; System.out.println("Inicio de sesión correcto!"); }
    }
}
