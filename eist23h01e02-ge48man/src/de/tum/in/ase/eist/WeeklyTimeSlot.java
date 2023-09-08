package de.tum.in.ase.eist;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class WeeklyTimeSlot extends TimeSlot{
    private DayOfWeek dayOfWeek;
    public WeeklyTimeSlot(DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTIme) {
        super(startTime, endTIme);
        this.dayOfWeek=dayOfWeek;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;

    }
}
