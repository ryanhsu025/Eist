package de.tum.in.ase.eist;

import java.time.LocalDate;
import java.time.LocalTime;

public class FixedDateTimeSlot extends TimeSlot{
	private LocalDate date;

	public FixedDateTimeSlot(LocalDate date,LocalTime startTime, LocalTime endTIme) {
		super(startTime, endTIme);
		this.date=date;
	}

	public LocalDate getDate() {
		return date;
	}

}
