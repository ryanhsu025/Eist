package de.tum.in.ase.eist;

import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        SeminarRoom seminarRoom = new SeminarRoom(4);
        Thread enter = new Thread(() -> {
            for (int i = 0; i < 25; i++) {
                try {
                    Student student = new Student(i + "_Max", "Mustermann");
                    seminarRoom.enter(student);
                    System.out.println(student.getForename() + " " + student.getSurname() + " entered the room.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    return;
                }
            }
        });
        Thread leave = new Thread(() -> {
            for (int i = 0; i < 25; i++) {
                try {
                    Student student = seminarRoom.leave();
                    System.out.println(student.getForename() + " " + student.getSurname() + " left the room.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    return;
                }

            }
        });
        enter.start();
        leave.start();

        enter.join();
        leave.join();
    }

    /**
     * Checks if student has valid Student ID.
     *
     * @return matriculation number if student ID is valid, or -1 if not valid
     */
    public static int validStudentID(Student student, int lowerBound) {
        Student.StudentID studentID = student.hasValidID(lowerBound);
        if(studentID == null){
            return -1;
        }
        return studentID.getMatriculationNo();
    }
}
