package com.boost.training.School;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Optional;
import java.util.Scanner;

public class StudentManager {

	Student student;
	Scanner scanner = new Scanner(System.in);

	public Optional<Student> createStudent() {
		Student student = new Student(controlName(), controlAge(), controlMark());
		System.out.println(student.getName() + " is created successfully...");
		return Optional.ofNullable(student);
	}

	public String controlName() throws Exception_IrrelevantNameInput {
		System.out.println("Enter the student name");
		String name = scanner.nextLine();

		if (name.length() < 3) {
			try {
				throw new Exception_IrrelevantNameInput("You must enter any name with 3 character at least");
			} catch (Exception_IrrelevantNameInput e) {
				System.out.println(e.getMessage());
			}
		}
		return name;
	}

	public LocalDate controlAge() throws Exception_UnderAge {

		LocalDate date = Utils.stringToLocalDateControl("Please enter the date");

		int years = calcAge(date);

		if (years < 8) {
			try {
				throw new Exception_UnderAge("The age of Student should be 8+ at least");
			} catch (Exception_UnderAge e) {
				System.out.println(e.getMessage());
			}
		}
		return date;

	}

	public int calcAge(LocalDate date) {
		return (int) date.until(LocalDate.now(), ChronoUnit.YEARS);
	}

	public Double[] controlMark() throws Exception_MarkValueDismatch {

		int flag = 1;
		Double[] marks = new Double[3];

		do {
			Double number = Utils.readDouble("Please enter the " + flag + ". mark.");
			if (number > 100 || number < 0) {
				try {
					throw new Exception_MarkValueDismatch("You must enter the mark btw 0-100 please...");
				} catch (Exception_MarkValueDismatch e) {
					System.out.println(e.getMessage());
				} catch (ArrayIndexOutOfBoundsException e) {
					System.out.println(e.getMessage());
				}
			} else {
				marks[flag - 1] = number;
				flag++;
			}
		} while (flag < 4);
		return marks;
	}

}
