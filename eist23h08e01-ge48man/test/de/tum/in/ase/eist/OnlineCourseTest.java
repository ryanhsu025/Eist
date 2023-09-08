package de.tum.in.ase.eist;

import org.junit.jupiter.api.*;

import java.net.MalformedURLException;

import static org.junit.jupiter.api.Assertions.*;

class OnlineCourseTest {
    @Test
    public void testSetOnlineCourseUrlWithValidUrl() {
        OnlineCourse onlineCourse = new OnlineCourse("informatik");
        try {
            onlineCourse.setUrl("https://tum.com");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        assertEquals("https://tum.com", onlineCourse.getUrl().toString());
    }

	@Test
    public void testSetOnlineCourseUrlWithInvalidUrl() {
        OnlineCourse onlineCourse = new OnlineCourse("informatik");
        assertThrows(MalformedURLException.class, () -> onlineCourse.setUrl("invalid"));
    }

}
