package de.tum.in.ase.eist;

import java.util.*;

public class TutorGroup {
	private String id;
    private WeeklyTimeSlot timeSlot;
    private Person tutor;
    private Set<Student> students;
    private List<TutorGroupMeeting> meetings;

    public TutorGroup(String id, WeeklyTimeSlot timeSlot, Person tutor){
        this.id=id;
        this.timeSlot=timeSlot;
        this.tutor=tutor;
        students=new HashSet<>();
        meetings=new ArrayList<>();
    }

    void addMeeting(TutorGroupMeeting meeting){
        meetings.add(meeting);
    }

    public void register(Student student){
        students.add(student);
    }
    public String getId() {
        return id;
    }

    public WeeklyTimeSlot getTimeSlot() {
        return timeSlot;
    }

    public Person getTutor() {
        return tutor;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public List<TutorGroupMeeting> getMeetings() {
        return meetings;
    }
}
