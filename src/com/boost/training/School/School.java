package com.boost.training.School;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class School {

	StudentManager studentManager;
	List<Student> studentList;

	public School() {

		studentList = new ArrayList<Student>();
		studentManager = new StudentManager();
	}

	public void addList(Optional<Student>... student) {

		for (int i = 0; i < student.length; i++) {

			if (student[i].isEmpty()) {

				try {
					throw new Exception_Student("You cannot add null value");
				} catch (Exception_Student e) {
					System.out.println(e.getMessage());
				}

			} else {
				studentList.add(student[i].get());
			}
		}
	}

	public static void main(String[] args) throws IOException, InterruptedException {

		School school = new School();
		FileUtils fileUtils = new FileUtils();
		Optional<Student> student01 = school.studentManager.createStudent();
		student01.get().setMarks(school.studentManager.controlMark());
		Optional<Student> student02 = school.studentManager.createStudent();
		student02.get().setMarks(school.studentManager.controlMark());
		Optional<Student> student03 = school.studentManager.createStudent();
		student03.get().setMarks(school.studentManager.controlMark());

		school.addList(student01, student02, student03);
		// school.studentList.forEach(System.out::println);

		fileUtils.writeToFile(fileUtils.file, school.studentList);
		List<String> readList = fileUtils.readTheFile(fileUtils.file);
		// System.out.println(readList);

		school.studentManager.createStudentBy(readList);

	}

}
