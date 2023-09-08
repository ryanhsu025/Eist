package de.tum.in.ase.eist;

public  abstract class  TutorGroupMeeting {
	private  FixedDateTimeSlot timeSlot;
    private TutorGroup tutorGroup;
    private Skill skillToPractise;

    public TutorGroupMeeting(FixedDateTimeSlot timeSlot, TutorGroup tutorGroup, Skill skillToPractise){
        this.timeSlot=timeSlot;
        this.tutorGroup=tutorGroup;
        this.skillToPractise=skillToPractise;
    }

    public abstract void practise();

    public FixedDateTimeSlot getTimeSlot() {
        return timeSlot;
    }

    public TutorGroup getTutorGroup() {
        return tutorGroup;
    }

    public Skill getSkillToPractise() {
        return skillToPractise;
    }
}
