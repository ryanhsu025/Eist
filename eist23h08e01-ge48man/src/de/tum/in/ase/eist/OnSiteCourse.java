package de.tum.in.ase.eist;

import java.awt.*;

public class OnSiteCourse extends Course {

	private Point location;

	public OnSiteCourse(String title, Point location) {
		super(title);
		this.setLocation(location);
	}

	public Point getLocation() {
		return location;
	}

	public void setLocation(Point location) {
		this.location = location;
	}
}
