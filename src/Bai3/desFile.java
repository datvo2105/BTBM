/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Bai3;

import java.awt.FileDialog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.security.Key;
import javax.swing.JOptionPane;

/**
 *
 * @author vogiadat
 */
public class desFile extends javax.swing.JFrame {

	private DES des;

	public desFile() {
		des = new DES();
		initComponents();
	}

	protected File getFileDialogOpen(String filter) {
		FileDialog fd = new FileDialog(this, "Select File", FileDialog.LOAD);
		fd.setFile(filter);
		fd.setVisible(true);

		if (fd.getFile() == null) {
			return null;
		}
		File file = new File(fd.getDirectory() + fd.getFile());

		if (!file.canRead()) {
			JOptionPane.showMessageDialog(null, "Selected file can't be read.", "Error", JOptionPane.ERROR_MESSAGE);
			return null;
		}
		return file;
	}

	protected byte[] readByteFile(File file) {
		byte[] data;
		try {
			FileInputStream fis = new FileInputStream(file);
			int c, i = 0;
			data = new byte[(int) file.length()];
			while ((c = fis.read()) != -1) {
				data[i++] = (byte) c;
			}
			fis.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, file.getName() + " not found or can't be read.", "Error", JOptionPane.ERROR_MESSAGE);
			return null;
		}
		return data;
	}

	protected boolean writeByteFile(String fileName, byte[] data) {
		File file = new File(fileName);
		if (!file.canWrite()) {
			try {
				file.createNewFile();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Unable to create file" + file.getName() + " for writing.", "Error", JOptionPane.ERROR_MESSAGE);
				return false;
			}
		}

		try {
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(data);
			fos.close();
			return true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Unable to create file" + file.getName() + " for writing.", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}

	protected Object readObjectFile(File file) {
		Object obj;

		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
			obj = (Object) ois.readObject();
			ois.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, file.getName() + " not found or can't be read.", "Error", JOptionPane.ERROR_MESSAGE);
			return null;
		}
		return obj;
	}

	protected boolean writeObjectFile(String fileName, Object data) {
		File file = new File(fileName);
		if (!file.canWrite()) {
			try {
				file.createNewFile();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Unable to create file" + file.getName(), "Error", JOptionPane.ERROR_MESSAGE);
				return false;
			}
		}

		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
			oos.writeObject(data);
			oos.close();
			return true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Unable to create file" + file.getName(), "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}

	@SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                Table = new javax.swing.JTabbedPane();
                Encrypt = new javax.swing.JPanel();
                jLabel1 = new javax.swing.JLabel();
                jLabel2 = new javax.swing.JLabel();
                txtFileEncrypt = new javax.swing.JTextField();
                chooseEncryptFile = new javax.swing.JButton();
                btnEncrypt = new javax.swing.JToggleButton();
                Decrypt = new javax.swing.JPanel();
                jLabel3 = new javax.swing.JLabel();
                txtFileDecrypt = new javax.swing.JTextField();
                jLabel4 = new javax.swing.JLabel();
                chooseDecryptFile = new javax.swing.JButton();
                txtFileKey = new javax.swing.JTextField();
                jLabel5 = new javax.swing.JLabel();
                chooseKey = new javax.swing.JButton();
                btnDecrypt = new javax.swing.JToggleButton();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

                jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
                jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                jLabel1.setText("Select a file to be encrypted");

                jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
                jLabel2.setText("File:");

                txtFileEncrypt.setEditable(false);

                chooseEncryptFile.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
                chooseEncryptFile.setText("...");
                chooseEncryptFile.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                chooseEncryptFileActionPerformed(evt);
                        }
                });

                btnEncrypt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
                btnEncrypt.setText("Encrypt");
                btnEncrypt.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnEncryptActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout EncryptLayout = new javax.swing.GroupLayout(Encrypt);
                Encrypt.setLayout(EncryptLayout);
                EncryptLayout.setHorizontalGroup(
                        EncryptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(EncryptLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(EncryptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(EncryptLayout.createSequentialGroup()
                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtFileEncrypt, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(chooseEncryptFile, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
                        .addGroup(EncryptLayout.createSequentialGroup()
                                .addGap(155, 155, 155)
                                .addComponent(btnEncrypt, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
                EncryptLayout.setVerticalGroup(
                        EncryptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(EncryptLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(30, 30, 30)
                                .addGroup(EncryptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(txtFileEncrypt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(chooseEncryptFile))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                                .addComponent(btnEncrypt)
                                .addContainerGap())
                );

                Table.addTab("Encrypte", Encrypt);

                jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
                jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                jLabel3.setText("Select a file to be decrypted and add key");

                txtFileDecrypt.setEditable(false);

                jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
                jLabel4.setText("File:");

                chooseDecryptFile.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
                chooseDecryptFile.setText("...");
                chooseDecryptFile.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                chooseDecryptFileActionPerformed(evt);
                        }
                });

                txtFileKey.setEditable(false);

                jLabel5.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
                jLabel5.setText("Key:");

                chooseKey.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
                chooseKey.setText("...");
                chooseKey.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                chooseKeyActionPerformed(evt);
                        }
                });

                btnDecrypt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
                btnDecrypt.setText("Decrypt");
                btnDecrypt.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnDecryptActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout DecryptLayout = new javax.swing.GroupLayout(Decrypt);
                Decrypt.setLayout(DecryptLayout);
                DecryptLayout.setHorizontalGroup(
                        DecryptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(DecryptLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(DecryptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(DecryptLayout.createSequentialGroup()
                                                .addGroup(DecryptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(DecryptLayout.createSequentialGroup()
                                                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(txtFileDecrypt, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(chooseDecryptFile, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(DecryptLayout.createSequentialGroup()
                                                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(txtFileKey, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(chooseKey, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
                        .addGroup(DecryptLayout.createSequentialGroup()
                                .addGap(152, 152, 152)
                                .addComponent(btnDecrypt, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
                DecryptLayout.setVerticalGroup(
                        DecryptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(DecryptLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(DecryptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(txtFileDecrypt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(chooseDecryptFile))
                                .addGap(18, 18, 18)
                                .addGroup(DecryptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5)
                                        .addComponent(txtFileKey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(chooseKey))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                                .addComponent(btnDecrypt)
                                .addContainerGap())
                );

                Table.addTab("Decrypt", Decrypt);

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(Table)
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(Table)
                );

                pack();
        }// </editor-fold>//GEN-END:initComponents

        private void chooseEncryptFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseEncryptFileActionPerformed
		File file = getFileDialogOpen("*.*");
		if (file == null) {
			return;
		}
		txtFileEncrypt.setText(file.getAbsolutePath());
        }//GEN-LAST:event_chooseEncryptFileActionPerformed

        private void chooseDecryptFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseDecryptFileActionPerformed
		File file = getFileDialogOpen("*.enc");
		if (file == null) {
			return;
		}
		txtFileDecrypt.setText(file.getAbsolutePath());
        }//GEN-LAST:event_chooseDecryptFileActionPerformed

        private void chooseKeyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseKeyActionPerformed
		File file = getFileDialogOpen("*.key");
		if (file == null) {
			return;
		}
		txtFileKey.setText(file.getAbsolutePath());
        }//GEN-LAST:event_chooseKeyActionPerformed

        private void btnEncryptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEncryptActionPerformed
		File file = new File(txtFileEncrypt.getText());
		byte data[] = readByteFile(file);

		data = des.encryptFile(data);
		if (writeByteFile(file.getAbsolutePath() + ".enc", data) && writeObjectFile(file.getAbsolutePath() + ".key", des.getKey())) {
			file.delete();
			JOptionPane.showMessageDialog(null, file.getAbsoluteFile() + ".enc\n Encryption key: " + file.getName() +".key\n", "Done", JOptionPane.INFORMATION_MESSAGE);
			txtFileDecrypt.setText("");
		}
        }//GEN-LAST:event_btnEncryptActionPerformed

        private void btnDecryptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDecryptActionPerformed
		File file = new File(txtFileDecrypt.getText());
		File keyFile = new File(txtFileKey.getText());

		if(!file.exists()){
			JOptionPane.showMessageDialog(null, "Encrypted file not found!!", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		if(!keyFile.exists()) {
			JOptionPane.showMessageDialog(null, "Key file not found!!", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}

		byte data[] = readByteFile(file);
		Key key= (Key)readObjectFile(keyFile);
		data = des.decryptFile(data, key);

		String fileName = file.getAbsolutePath().substring(0, file.getAbsolutePath().length()-3);
		if (writeByteFile(fileName, data)) {
			file.delete();
			keyFile.delete();
			JOptionPane.showMessageDialog(null, "Decrypt file success!!", "Done", JOptionPane.INFORMATION_MESSAGE);
			txtFileDecrypt.setText("");
			txtFileKey.setText("");
		}
        }//GEN-LAST:event_btnDecryptActionPerformed

	

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
		/* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(desFile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(desFile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(desFile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(desFile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new desFile().setVisible(true);
			}
		});
	}

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JPanel Decrypt;
        private javax.swing.JPanel Encrypt;
        private javax.swing.JTabbedPane Table;
        private javax.swing.JToggleButton btnDecrypt;
        private javax.swing.JToggleButton btnEncrypt;
        private javax.swing.JButton chooseDecryptFile;
        private javax.swing.JButton chooseEncryptFile;
        private javax.swing.JButton chooseKey;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JLabel jLabel4;
        private javax.swing.JLabel jLabel5;
        private javax.swing.JTextField txtFileDecrypt;
        private javax.swing.JTextField txtFileEncrypt;
        private javax.swing.JTextField txtFileKey;
        // End of variables declaration//GEN-END:variables
}
