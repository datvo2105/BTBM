/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bai1.CaesarORCL;

import java.sql.*;
import javax.swing.JOptionPane;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author vogiadat
 */

public class CaesarPKG {

	private Connection conn;

	public CaesarPKG(Connection conn) {
		this.conn = conn;
	}

	public String caeserEncrypt_Proc(String msg, int key) {
		try {
			String sql = "{CALL caesarCrypt.Proc_encryptMessage(?, ?, ?)}";
			CallableStatement csm = conn.prepareCall(sql);
			csm.setString(1, msg);
			csm.setInt(2, key);
			csm.registerOutParameter(3, OracleTypes.VARCHAR);
			csm.execute();

			String output = csm.getString(3);
			csm.close();
			return output;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getErrorCode() + "#" + e.getMessage());
		}
		return null;
	}

	public String caeserDecrypt_Proc(String msg, int key) {
		try {
			String sql = "{CALL caesarCrypt.Proc_decryptMessage(?, ?, ?)}";
			CallableStatement csm = conn.prepareCall(sql);
			csm.setString(1, msg);
			csm.setInt(2, key);
			csm.registerOutParameter(3, OracleTypes.VARCHAR);
			csm.execute();

			String output = csm.getString(3);
			csm.close();
			return output;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getErrorCode() + "#" + e.getMessage());
		}
		return null;
	}

	public String caeserEncrypt_Func(String msg, int key) {
		try {
			String sql = "BEGIN ? := caesarCrypt.Func_encryptMessage(?,?); END;";
			CallableStatement csm = conn.prepareCall(sql);
			csm.registerOutParameter(1, OracleTypes.VARCHAR);
			csm.setString(2, msg);
			csm.setInt(3, key);
			csm.execute();

			String output = csm.getString(1);
			csm.close();
			return output;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getErrorCode() + "#" + e.getMessage());
		}
		return null;
	}

	public String caeserDecrypt_Func(String msg, int key) {
		try {
			String sql = "BEGIN ? := caesarCrypt.Func_decryptMessage(?,?); END;";
			CallableStatement csm = conn.prepareCall(sql);
			csm.registerOutParameter(1, OracleTypes.VARCHAR);
			csm.setString(2, msg);
			csm.setInt(3, key);
			csm.execute();

			String output = csm.getString(1);
			csm.close();
			return output;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getErrorCode() + "#" + e.getMessage());
		}
		return null;
	}
}
