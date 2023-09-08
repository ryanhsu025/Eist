package de.tum.in.ase.eist;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Course {

	private String title;
	private Lecturer lecturer;
	private List<Date> dates;
	private List<Student> attendees = new ArrayList<>();

	public Course(String title) {
		this.title = title;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Lecturer getLecturer() {
		return lecturer;
	}

	public void setLecturer(Lecturer lecturer) {
		this.lecturer = lecturer;
	}

	public List<Date> getDates() {
		return dates;
	}

	public void setDates(List<Date> dates) {
		this.dates = dates;
	}

	public List<Student> getAttendees() {
		return attendees;
	}

	public void addAttendee(Student student) {
		if (this.attendees != null && !this.attendees.contains(student)) {
			this.attendees.add(student);
		}
	}

	public void setAttendees(List<Student> attendees) {
		this.attendees = attendees;
	}

	public int getNumberOfAttendees() {
		return attendees.size();
	}
}
