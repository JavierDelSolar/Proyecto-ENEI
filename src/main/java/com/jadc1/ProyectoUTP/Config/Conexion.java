package com.jadc1.ProyectoUTP.Config;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
	private String URL = "localhost:3306";
	private String BD = "bd_biblioteca";
	private String USER = "root";
	private String PASS = "";
	
	Connection cn;
	
	public Conexion() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://" + URL + "/" + BD, USER, PASS);
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		return cn;
	}
}
