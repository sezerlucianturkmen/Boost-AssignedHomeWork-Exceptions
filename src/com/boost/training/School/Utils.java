package com.boost.training.School;

import java.time.LocalDate;
import java.util.Scanner;

public class Utils {

	static Scanner scanner = new Scanner(System.in);

	public static LocalDate stringToLocalDateControl(String string) {

		LocalDate date = null;
		String value = "";
		boolean control = false;

		do {
			try {
				System.out.println(string);
				value = scanner.nextLine();
				date = LocalDate.parse(value);
				control = false;

			} catch (Exception e) {
				System.err.println("Wrong entry..");
				control = true;
			}
		} while (control);
		return date;
	}

	public static double readDouble(String string) {

		double value = 0;
		boolean control = false;

		do {
			try {
				System.out.println(string);
				value = Double.parseDouble(scanner.nextLine());
				control = false;
			} catch (Exception e) {
				System.err.println("Wrong entry..");
				control = true;
			}
		} while (control);
		return value;

	}

}
