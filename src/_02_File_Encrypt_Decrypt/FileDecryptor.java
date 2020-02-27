package _02_File_Encrypt_Decrypt;

import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.JOptionPane;

public class FileDecryptor {
	// Create a program that opens the file created by FileEncryptor and display
	// the decrypted message to the user in a JOptionPane.
	public static void main(String[] args) {
		FileDecryptor fd = new FileDecryptor();
		fd.decryptFile();
	}

	public void decryptFile() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/_02_File_Encrypt_Decrypt/textFile.txt"));
			String rl = br.readLine();
			System.out.println(rl);
			JOptionPane.showMessageDialog(null, rl);
			br.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("not working");
		}
	}
}
