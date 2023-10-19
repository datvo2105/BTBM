/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConnectDB;

import java.sql.*;

/**
 *
 * @author vogiadat
 */
public class Database {

	public static String url = "jdbc:oracle:thin:@localhost:1521:";

	public static String db = "";
	public static String user = "";
	public static String pass = "";
	public static Connection conn;

	public static boolean Connect() {
		try {
			if (user.equalsIgnoreCase("sys")) {
				user += " as sysdba";
			}
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url + db, user, pass);
			return true;
		} catch (ClassNotFoundException | SQLException e) {
			return false;
		}
	}

	public static Connection getConnect() {
		if (conn == null) {
			Connect();
		}
		return conn;
	}

}
