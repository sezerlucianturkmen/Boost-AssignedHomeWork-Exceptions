package com.boost.training.School;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

	public static String path = "StudentList.txt";
	public static File file = new File(path);

	public FileUtils() throws IOException, InterruptedException {
		System.out.println("StudentList is creating.");
		file.createNewFile();
		Thread.sleep(1000);
	}

	public void writeToFile(File file, List<Student> studentList) throws InterruptedException {

		BufferedWriter writer = null;
		try {

			for (Student student : studentList) {

				String string = "";

				for (int i = 0; i < student.getMarks().length; i++) {
					string += "," + student.getMarks()[i];
				}
				writer = new BufferedWriter(new FileWriter(file, true));
				writer.write(student.getName() + "," + student.getDate() + string + "\n");
				writer.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("List is writing...");
		Thread.sleep(1000);
		System.out.println("Students are written in the List");
	}

	public List<String> readTheFile(File file) throws InterruptedException {
		BufferedReader reader = null;
		List<String> myList = new ArrayList<String>();
		String text = "";
		try {
			String read = "";
			reader = new BufferedReader(new FileReader(file));
			while ((read = reader.readLine()) != null) {
				myList.add(read);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("List is reading...");
		Thread.sleep(1000);
		System.out.println("List is read and ready to use .");
		return myList;

	}

}
