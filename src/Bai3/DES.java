/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bai3;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import java.security.Security;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.pqc.jcajce.provider.BouncyCastlePQCProvider;

/**
 *
 * @author vogiadat
 */
public class DES {

	private Key key;
	private BouncyCastlePQCProvider SunJCE = new BouncyCastlePQCProvider();

	public Key getKey() {
		return key;
	}

	public byte[] encryptFile(byte[] file) {
		key = null;
		try {
			Security.addProvider(SunJCE);
			KeyGenerator KG = KeyGenerator.getInstance("DES");
			Cipher cipher = Cipher.getInstance("DES");

			key = KG.generateKey();

			cipher.init(Cipher.ENCRYPT_MODE, key);
			return (cipher.doFinal(file));
		} catch (Exception e) {
			return null;
		}
	}

	public byte[] decryptFile(byte[] file, Key key) {
		try {
			Security.addProvider(SunJCE);
			Cipher cipher = Cipher.getInstance("DES");

			cipher.init(Cipher.DECRYPT_MODE, key);
			return cipher.doFinal(file);
		} catch (Exception e) {
			return null; 
		}
	}
}
