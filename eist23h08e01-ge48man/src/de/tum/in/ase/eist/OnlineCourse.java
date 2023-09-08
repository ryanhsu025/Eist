package de.tum.in.ase.eist;

import java.net.MalformedURLException;
import java.net.URL;

public class OnlineCourse extends Course {

	private URL url;

	public OnlineCourse(String title) {
		super(title);
	}

	public URL getUrl() {
		return url;
	}

	public void setUrl(String urlString) throws MalformedURLException {
		url = new URL(urlString);
	}
}
