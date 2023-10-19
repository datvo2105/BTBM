/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bai2;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author vogiadat
 */
public class desPKG {

	private Connection conn;

	public desPKG(Connection conn) {
		this.conn = conn;
	}

	public String encryptMessage_Func(String message, String key) {
		try {
			String sql = "{? = CALL desCipher.Func_encryptMessage(?, ?)}";
			String output;
			try (CallableStatement csm = conn.prepareCall(sql)) {
				csm.registerOutParameter(1, Types.VARBINARY);
				csm.setString(2, message);
				csm.setString(3, key);
				csm.execute();
				output = csm.getString(1);
			}
			return String.valueOf(output);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getErrorCode() + "#" + e.getMessage());
		}
		return null;
	}

	public String decryptMessage_Func(String msgEncrypted, String key) {
		try {
			String sql = "{? = CALL desCipher.Func_decryptMessage(?, ?)}";
			String output;
			try (CallableStatement csm = conn.prepareCall(sql)) {
				csm.registerOutParameter(1, Types.VARCHAR);
				csm.setString(2, msgEncrypted);
				csm.setString(3, key);
				csm.execute();
				output = csm.getString(1);
			}
			return output;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getErrorCode() + "#" + e.getMessage());
		}
		return null;
	}
}
