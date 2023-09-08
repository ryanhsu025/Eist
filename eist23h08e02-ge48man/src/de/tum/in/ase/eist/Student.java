package de.tum.in.ase.eist;

import java.time.LocalDate;
import java.util.List;

public class Student extends Person {

    private String majorSubject;
    private String minorSubject;
    private List<Course> courses;
    private int studentId;

    public Student(String firstName, String lastName, LocalDate birthDate, String majorSubject, String minorSubject) {
        super(firstName, lastName, birthDate);
        this.majorSubject = majorSubject;
        this.minorSubject = minorSubject;
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

    @Override
    public void printPersonalInformation() {
        System.out.printf("Student: %s %s, %s, %d", getFirstName(), getLastName(), getBirthDate(), studentId);
    }

}

