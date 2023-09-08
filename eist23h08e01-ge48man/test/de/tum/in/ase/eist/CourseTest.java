package de.tum.in.ase.eist;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CourseTest {

	@Test
	public void testGetCourseTitle() {
		Course course = new Course("informatik");
		assertEquals("informatik", course.getTitle());
	}



	@Test
	public void testNoAttendees() {
		Course course = new Course("informatik");
		assertEquals(0, course.getNumberOfAttendees());
	}

	@Test
	public void testThreeAttendees() {
		Course course = new Course("informatik");
		course.addAttendee(new Student("Lucy", "Yang", "01012001", "informatik", "mathematik"));
		course.addAttendee(new Student("Lucy", "Yang", "01012001", "informatik", "mathematik"));
		course.addAttendee(new Student("Lucy", "Yang", "01012001", "informatik", "mathematik"));
		assertEquals(3, course.getNumberOfAttendees());
	}

}
