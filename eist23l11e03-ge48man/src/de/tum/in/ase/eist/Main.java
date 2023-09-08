package de.tum.in.ase.eist;

public class Main {

    private Main() {
    }

    // TODO: Test your solution with this main method, exceptions may be thrown before the bugs are fixed!
    public static void main(String[] args) {
        String forename1 = "Erika";
        String surname1 = "Musterfrau";
        String forename2 = "Max";
        String surname2 = "Mustermann";

        Student student1 = new Student(forename1, surname1);
        Student student2 = new Student(forename2, surname2);

        Course course = new Course("EIST");
        course.addParticipant(student1);
        course.addParticipant(student2);

        TUMOnline tumOnline = new TUMOnline();
        tumOnline.enrolStudent(student1);
        tumOnline.enrolStudent(student2);
        tumOnline.registerCourse(course);
        Student foundStudent = tumOnline.findStudentByName(forename1, surname1);

        if (foundStudent == null) {
            throw new RuntimeException(forename1 + " "  + surname1 + " was not found, despite being registered in the course!");
        }
    }

}
