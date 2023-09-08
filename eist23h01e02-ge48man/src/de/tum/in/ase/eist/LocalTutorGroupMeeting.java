package de.tum.in.ase.eist;

public class LocalTutorGroupMeeting extends TutorGroupMeeting {
    private String room;
    public LocalTutorGroupMeeting(FixedDateTimeSlot timeSlot, TutorGroup tutorGroup, Skill skillToPractise,String room) {
        super(timeSlot, tutorGroup, skillToPractise);
        this.room=room;
    }
    public void practise(){
        getTutorGroup().getTutor().say("Thank you for coming to "+room+" today.");
        for(Student student:getTutorGroup().getStudents()){
            student.learnSkill(super.getSkillToPractise());
        }
        getTutorGroup().getTutor().say("See you next time!");
    }

    public String getRoom() {
        return room;
    }
}
