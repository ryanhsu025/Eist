package de.tum.in.ase.eist;

import org.easymock.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import java.time.LocalDate;
import java.util.Locale;

import static org.easymock.EasyMock.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(EasyMockExtension.class)
class DiscussionTest {
    @TestSubject
    private  Discussion discussion = new Discussion();
    @Mock
    private Course courseMock;
    @Mock
    private Comment commentMock;
    // TODO implement the tests

    @Test
    void testComment() {
        int expectedSize = discussion.getNumberOfComments() + 1;
        expect(commentMock.save()).andReturn(true);
        replay(commentMock);
        discussion.addComment(commentMock);
        assertEquals(expectedSize, discussion.getNumberOfComments());
        verify(commentMock);
    }

    @Test
    void testCommentIfSavingFails() {
        int expectedSize = discussion.getNumberOfComments();
        expect(commentMock.save()).andReturn(false);
        replay(commentMock);
        discussion.addComment(commentMock);
        assertEquals(expectedSize, discussion.getNumberOfComments());
        verify(commentMock);
    }

    @Test
    void testStartCourseDiscussion() {
        Person student = new Student("Junguo", "Xu", LocalDate.now(), "Informatik", "Mathematik");
        expect(courseMock.isDiscussionAllowed(student)).andReturn(true);
        replay(courseMock);
        assertEquals(true, discussion.startCourseDiscussion(courseMock, student, "Informatik"));
        assertEquals(courseMock, discussion.getCourse());
        assertEquals("Informatik", discussion.getTopic());
        verify(courseMock);
    }

}
