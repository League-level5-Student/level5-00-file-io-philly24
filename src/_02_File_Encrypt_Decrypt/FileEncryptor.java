package _02_File_Encrypt_Decrypt;

import java.io.FileWriter;

import javax.swing.JOptionPane;

public class FileEncryptor {
	// Create a program that takes a message from the user.
	// Use the methods in the String and Character classes to save
	// an encrypted form of the message to a file
	public static void main(String[] args) {
		String string = JOptionPane.showInputDialog("message");
		char[] arr = string.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (char) (arr[i] + 5);
			System.out.println(arr[i]);

		}
		String str = new String(arr);
		try {
			FileWriter fw = new FileWriter("src/_02_File_Encrypt_Decrypt/textFile.txt");
			fw.write(string);
			fw.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
