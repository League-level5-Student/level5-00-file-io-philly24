package _01_File_Recorder;

import java.io.FileWriter;
import java.io.IOException;

public class FileRecorder {
	// Create a program that takes a message from the user and saves it to a file.

	public static void main(String[] args) {
		try {
			FileWriter fw = new FileWriter("src/_01_File_Recorder/text");
			fw.write("Joe Moma");
			fw.close();
			System.out.println("worked");
		} catch (Exception e) {
			System.out.println("error");
			e.printStackTrace();
		}
	}

}
