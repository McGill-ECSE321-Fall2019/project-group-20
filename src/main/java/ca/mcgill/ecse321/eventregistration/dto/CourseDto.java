package ca.mcgill.ecse321.eventregistration.dto;

import java.util.Collections;
import java.util.List;

public class CourseDto {
	private int number;
	private List<EventDto> events;

	public CourseDto() {
	}

	@SuppressWarnings("unchecked")
	public CourseDto(int i) {
		this(i, Collections.EMPTY_LIST);
	}

	public CourseDto(int i, List<EventDto> arrayList) {
		this.number = i;
		this.events = arrayList;
	}

	public int getNumber() {
		return number;
	}

	public List<EventDto> getEvents() {
		return events;
	}

	public void setEvents(List<EventDto> events) {
		this.events = events;
	}
}
