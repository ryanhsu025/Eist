package de.tum.in.ase.eist;

public class VirtualTutorGroupMeeting extends  TutorGroupMeeting{
	private String url;


	public VirtualTutorGroupMeeting(FixedDateTimeSlot timeSlot, TutorGroup tutorGroup, Skill skillToPractise,String url) {
		super(timeSlot, tutorGroup, skillToPractise);
		this.url=url;
	}
	public void practise(){
		getTutorGroup().getTutor().say("Thank you for joining using "+url+" today.");
		for(Student student:getTutorGroup().getStudents()){
			student.learnSkill(super.getSkillToPractise());
		}
		getTutorGroup().getTutor().say("See you next time!");
	}

	public String getUrl() {
		return url;
	}
}
