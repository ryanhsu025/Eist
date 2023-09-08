package de.tum.in.ase.eist;

import java.util.List;

public class Student extends Person {

	private String majorSubject;
	private String minorSubject;
	private List<Course> courses;
	private int studentId;

	public Student(String firstName, String lastName, String birthDate, String majorSubject, String minorSubject) {
		super(firstName, lastName, birthDate);
		this.majorSubject = majorSubject;
		this.minorSubject = minorSubject;
	}

	@Override
	public void printPersonalInformation() {
		System.out.println("Student: " + getFirstName() + " " + getLastName() + " " + getBirthDate() + " " + studentId);
	}

	public String getMajorSubject() {
		return majorSubject;
	}

	public void setMajorSubject(String majorSubject) {
		this.majorSubject = majorSubject;
	}

	public String getMinorSubject() {
		return minorSubject;
	}

	public void setMinorSubject(String minorSubject) {
		this.minorSubject = minorSubject;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
}
