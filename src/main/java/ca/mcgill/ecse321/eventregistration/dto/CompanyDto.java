package ca.mcgill.ecse321.eventregistration.dto;

import java.util.Collections;
import java.util.List;

public class CompanyDto {
	private String name;
	private List<EventDto> events;

	public CompanyDto() {
	}

	@SuppressWarnings("unchecked")
	public CompanyDto(String name) {
		this(name, Collections.EMPTY_LIST);
	}

	public CompanyDto(String name, List<EventDto> arrayList) {
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
