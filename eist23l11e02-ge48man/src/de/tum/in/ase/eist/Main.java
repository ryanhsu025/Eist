package de.tum.in.ase.eist;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.DayOfWeek;
import java.time.LocalTime;

public final class Main {
	private Main() {

	}

	public static void main(String[] args) throws MalformedURLException {

		TimeSlot timeSlot = new TimeSlot(DayOfWeek.FRIDAY, LocalTime.of(10, 0), LocalTime.of(12, 0));
		Student tutor = new Student("Johannes", 21, "ge25cus", "0123456789", 4);
		TutorGroup tutorGroup = new TutorGroup("Fr01", timeSlot, tutor);
		Skill softwareQualityManagement = new Skill("Software Quality Management");

		Student student1 = new Student("Simon", 19, "ge97zag", "03894452", 2);
		Student student2 = new Student("Jan-Luca", 21, "ge38waz", "03894453", 2);
		Student student3 = new Student("Manuela", 19, "ge35giz", "03894454", 2);

		tutorGroup.register(student1);
		tutorGroup.register(student2);
		tutorGroup.register(student3);

		PhysicalTutorGroupMeeting localTutorGroup = new PhysicalTutorGroupMeeting(timeSlot, tutorGroup,
				softwareQualityManagement, "MI 01.07.014");
		localTutorGroup.practice();

		TimeSlot timeSlot2 = new TimeSlot(DayOfWeek.WEDNESDAY, LocalTime.of(16, 0), LocalTime.of(18, 0));
		Student tutor2 = new Student("Christian", 20, "ge25rem", "1234567890", 4);
		TutorGroup tutorGroup2 = new TutorGroup("Mi17", timeSlot2, tutor2);

		Student studentOnline = new Student("Tobias", 20, "ga55zzz", "03141592", 2);
		tutorGroup2.register(studentOnline);

		VirtualTutorGroupMeeting virtualTutorGroup = new VirtualTutorGroupMeeting(timeSlot2, tutorGroup2,
				softwareQualityManagement,
				new URL("https://tum-conf.zoom.us/j/99711605391?pwd=R3NjVGs2Y2lReVVXdk1ZaFBSMk9sUT09"));
		virtualTutorGroup.practice();
	}

}
