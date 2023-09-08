package de.tum.in.ase.eist;

import java.time.LocalDate;
import java.util.List;

public class Lecturer extends Person {

    private List<Course> courses;
    private int employeeId;

    public Lecturer(String firstName, String lastName, LocalDate birthDate) {
        super(firstName, lastName, birthDate);
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public void printPersonalInformation() {
        System.out.printf("Lecturer: %s %s, %s, %d", getFirstName(), getFirstName(), getBirthDate(), employeeId);
    }

}

