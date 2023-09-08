package de.tum.in.ase.eist;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class TutorGroupStatistics {

	private TutorGroupStatistics() {

	}

	public static double averageDuration(Stream<TutorGroupMeeting> meetingStream) {
		return meetingStream.collect(Collectors.averagingDouble((TutorGroupMeeting tutorGroupMeeting)->tutorGroupMeeting.getTutorGroup().getTimeSlot().getDuration().toSeconds()));
	}

	public static Set<Skill> repeatedSkills(Stream<TutorGroupMeeting> meetings) {
		List list=meetings.map((TutorGroupMeeting tutorGroupMeeting)->tutorGroupMeeting.getSkillToPractise()).collect(Collectors.toList());
		Set<Skill> distinct=new HashSet<>(list);
		Set<Skill> out=new HashSet<>();
		for(Skill skill:distinct){
			if(Collections.frequency(list,skill)>1){
				out.add(skill);
			}
		}
		return out;
	}
}
