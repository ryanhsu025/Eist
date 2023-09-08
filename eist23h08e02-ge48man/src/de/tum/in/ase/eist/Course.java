package de.tum.in.ase.eist;

import java.time.LocalDate;
import java.util.List;

public interface Course {

    boolean isDiscussionAllowed(Person person);

    String getTitle();

    void setTitle(String title);

    Lecturer getLecturer();

    void setLecturer(Lecturer lecturer);

    List<LocalDate> getDates();

    void setDates(List<LocalDate> dates);

    List<Student> getAttendees();

    void setAttendees(List<Student> attendees);

    void addAttendee(Student student);

    int getNumberOfAttendees();

}

