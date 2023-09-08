package de.tum.in.ase.eist;

public class Instructor {

	private final String tumId;
	private final String name;
	private int age;

	public Instructor(String name, int age, String tumId) {
		this.tumId = tumId;
		this.name = name;
		this.age = age;
	}
	
	public String getTumId() {
		return tumId;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public void teach(String content) {
		say("Please learn \"" + content + "\"");
	}

	public final void say(String text) {
		System.out.println(name + " said: " + text);
	}
}
