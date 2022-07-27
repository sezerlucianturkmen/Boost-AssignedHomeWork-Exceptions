package com.boost.training.School;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Arrays;

public class Student implements Serializable {

	private String name;
	private LocalDate date;
	private Double[] marks;

	public Student(String name, LocalDate date, Double[] marks) {
		super();
		this.name = name;
		this.date = date;
		this.marks = marks;
	}

	public Student(String name, LocalDate date) {
		super();
		this.name = name;
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Double[] getMarks() {
		return marks;
	}

	public void setMarks(Double[] marks) {
		this.marks = marks;
	}

	public String giveMarks(Student student) {

		String markString = "";
		Double[] marks = student.getMarks();
		for (Double mark : marks) {
			markString += "," + mark;
		}
		return markString;
	}

	@Override
	public String toString() {
		final int maxLen = 10;
		return "Student [name=" + name + ", date=" + date + ", marks="
				+ (marks != null ? Arrays.asList(marks).subList(0, Math.min(marks.length, maxLen)) : null) + "]";
	}

}
