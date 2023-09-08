package de.tum.in.ase.eist;

import java.util.ArrayList;
import java.util.List;

public class Discussion {

    private String topic;
    private Course course;
    private final List<Comment> comments = new ArrayList<>();

    public boolean startCourseDiscussion(Course currentCourse, Person person, String currentTopic) {
        if (!currentCourse.isDiscussionAllowed(person)) {
            return false;
        }
        this.course = currentCourse;
        this.topic = currentTopic;

        return true;
    }

    public boolean addComment(Comment comment) {
        if (comment.save()) {
            comments.add(comment);
            return true;
        } else {
            return false;
        }
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public int getNumberOfComments() {
        return comments.size();
    }

}

