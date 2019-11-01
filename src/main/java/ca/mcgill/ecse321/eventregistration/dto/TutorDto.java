package ca.mcgill.ecse321.eventregistration.dto;

import java.util.Collections;
import java.util.List;

public class TutorDto {

	private String name;
	private String availability;
	private double hourlyRate;
	
	private List<EventDto> events;

	public TutorDto() {
	}

	@SuppressWarnings("unchecked")
	public TutorDto(String name) {
		this(name, Collections.EMPTY_LIST);
	}

	public TutorDto(String name, List<EventDto> arrayList) {
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
