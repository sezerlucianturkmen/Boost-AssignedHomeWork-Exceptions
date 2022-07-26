package com.boost.training.School;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class School {

	StudentManager studentManager = new StudentManager();
	List<Optional<Student>> studentList = new ArrayList<Optional<Student>>();

	public static void main(String[] args) {

		School school = new School();

		Scanner scanner = new Scanner(System.in);
		int pick = 0;
		do {

			System.out.println("-------------------------------------------------------");
			System.out.println("in order to add new student press 1, or to exit press 0");
			System.out.println("-------------------------------------------------------");
			pick = Integer.parseInt(scanner.nextLine());
			switch (pick) {
			case 1 -> {
				school.addStudent();
				break;
			}
			case 0 -> {
				school.studentList.forEach(System.out::println);
			}
			}
		} while (pick != 0);

	}

	public List<Optional<Student>> addStudent(Optional<Student>... students) {

		List<Optional<Student>> studentList = Arrays.asList(students);
		Optional<Student> student = studentManager.createStudent();

		if (student.isPresent()) {
			studentList.add(student);
		} else {
			try {
				throw new Exception_Student("Student cannot be null");
			} catch (Exception_Student e) {
				System.out.println(e.getMessage());
			}
		}
		return studentList;
	}

	public List<Optional<Student>> addStudent() {

		Optional<Student> student = studentManager.createStudent();

		if (student.isPresent()) {
			studentList.add(student);
		} else {
			try {
				throw new Exception_Student("Student cannot be null");
			} catch (Exception_Student e) {
				System.out.println(e.getMessage());
			}
		}
		return studentList;
	}

}
