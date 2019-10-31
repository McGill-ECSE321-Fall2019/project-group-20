package ca.mcgill.ecse321.eventregistration.dto;

import java.util.Collections;
import java.util.List;

public class FeedbackDto {
	private String name;
	private List<EventDto> events;

	public FeedbackDto() {
	}

	@SuppressWarnings("unchecked")
	public FeedbackDto(String name) {
		this(name, Collections.EMPTY_LIST);
	}

	public FeedbackDto(String name, List<EventDto> arrayList) {
		this.name = name;
		this.events = arrayList;
	}

	public String getName() {
		return name;
	}

	public List<EventDto> getEvents() {
		return events;
	}

	public void setEvents(List<EventDto> events) {
		this.events = events;
	}
}
