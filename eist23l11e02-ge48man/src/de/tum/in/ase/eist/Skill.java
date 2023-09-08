package de.tum.in.ase.eist;

public class Skill {
	
	private String skillName = "";

	public Skill(String skillName) {
		this.skillName = skillName;
	}

	public String getSkillName() {
		return skillName;
	}
	
    public void apply() {
		System.out.println("The skill " + skillName + " was applied");
	}
}
