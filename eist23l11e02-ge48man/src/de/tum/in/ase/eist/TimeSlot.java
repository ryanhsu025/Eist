package de.tum.in.ase.eist;

import java.time.*;

public class TimeSlot {
	
	private final DayOfWeek dayOfWeek;
	private final LocalTime startTime;
	private final LocalTime endTime;

	public TimeSlot(DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime) {
		this.dayOfWeek = dayOfWeek;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}
	
	public DayOfWeek getDayOfWeek() {
		return dayOfWeek;
	}

	public Duration getDuration() {
		return Duration.between(startTime, endTime);
	}
}
