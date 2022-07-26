package com.boost.training.School;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;

public class TestSerialization {

	public static void main(String[] args) {

		Student student = new Student("Ali", LocalDate.of(2000, 10, 10));

		try {
			FileOutputStream file = new FileOutputStream("test.txt");
			ObjectOutputStream write = null;
			write = new ObjectOutputStream(file);
			write.writeObject(student);
			System.out.println("Serialization is successful..");

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

		}

	}
}
