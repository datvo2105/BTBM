package Bai2;

import java.sql.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author vogiadat
 */
public class DB {

	public static Connection conn;
	public static String username = "";
	public static String password = "";

	public static Connection Connect() {
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";

		try {
			if (username.equalsIgnoreCase("sys")) username += " as sysdba";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, username, password);
			return conn;
		} catch (ClassNotFoundException | SQLException e) {
			return null;
		}
	}

	public static Connection getConnect() {
		if( conn != null) return conn;
		return Connect();
	}
}
