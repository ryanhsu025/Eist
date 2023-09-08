package de.tum.in.ase.eist;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class Student {
    private String forename;
    private String surname;
    private StudentID studentID;
    private static final int UPPERBOUND = 100000;
    public Student(String forename, String surname) {
        setForename(forename);
        setSurname(surname);
        this.studentID = new StudentID();
    }
    public String getForename() {
        return forename;
    }
    public void setForename(String forename) {
        forename.replaceAll("[^A-Za-z\\-]", "");
        this.forename = forename;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        surname.replaceAll("[^A-Za-z\\-]", "");
        this.surname = surname;
    }
    public StudentID getStudentID() { return studentID; }

    public void setStudentID(StudentID studentID) { this.studentID = studentID; }

    public StudentID hasValidID(int lowerBound) {
        if (studentID.matriculationNo >= lowerBound && studentID.matriculationNo <= UPPERBOUND) {
            return studentID;
        } else {
            return null;
        }
    }
    public FileOutputStream report() throws IOException {
        FileOutputStream file = new FileOutputStream("SeminarRoomPlan.txt");
        try {
            file.write("The student should enter this seminar room.".getBytes());
            return file;
        } finally {
            file.close();
        }
    }

    public static class StudentID {
        private int matriculationNo;
        private boolean lost;
        public StudentID() {
            Random random = new Random();
            matriculationNo = random.nextInt(UPPERBOUND);
            lost = false;
        }

        public int getMatriculationNo() { return matriculationNo; }
        public void setMatriculationNo(int matriculationNo) { this.matriculationNo = matriculationNo; }
        public boolean isLost() { return lost; }
        public void setLost() { lost = true; }
        public void orderNewID() {
            if (isLost()) {
                System.out.println("Ordered new Student ID.");
            }
        }
        public void print() {
            System.out.println("Student ID has matriculation number: " + matriculationNo);
        }
    }

}
