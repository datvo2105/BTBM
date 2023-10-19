/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bai2;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import java.util.Base64;

/**
 *
 * @author vogiadat
 */
public class DES {

	Cipher eCipher;
	Cipher dCipher;

	public DES(SecretKey key) throws Exception {
		eCipher = Cipher.getInstance("DES");
		dCipher = Cipher.getInstance("DES");

		eCipher.init(Cipher.ENCRYPT_MODE, key);
		dCipher.init(Cipher.DECRYPT_MODE, key);
	}

	public String encryptMessage(String message) throws Exception {
		byte[] msg = message.getBytes("UTF8");
		byte[] encrypt = eCipher.doFinal(msg);

		return new String(Base64.getEncoder().encodeToString(encrypt));
	}

	public String decryptMessage(String message) throws Exception {
		byte[] decrypt = Base64.getDecoder().decode(message);
		byte[] msg = dCipher.doFinal(decrypt);

		return new String(msg, "UTF8");
	}
}
