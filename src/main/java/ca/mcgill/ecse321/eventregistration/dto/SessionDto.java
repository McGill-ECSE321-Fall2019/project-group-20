package ca.mcgill.ecse321.eventregistration.dto;

import java.sql.Date;
import java.sql.Time;
import java.util.Collections;
import java.util.List;

import ca.mcgill.ecse321.eventregistration.model.Person;

public class SessionDto {
	boolean isRejected = false;
	private String studentName;
	private String tutorName;
	private Date date;
	private Time startTime;
	private Time endTime;
	
	public SessionDto(String studentName, String tutorName, Date date, Time startTime, Time endTime) {
		this.studentName = studentName;
		this.tutorName = tutorName;
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	public get
	
//	private String name;
//	private List<EventDto> events;
//
//	public SessionDto() {
//	}
//
//	@SuppressWarnings("unchecked")
//	public SessionDto(String name) {
//		this(name, Collections.EMPTY_LIST);
//	}
//
//	public SessionDto(String name, List<EventDto> arrayList) {
//		this.name = name;
//		this.events = arrayList;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public List<EventDto> getEvents() {
//		return events;
//	}
//
//	public void setEvents(List<EventDto> events) {
//		this.events = events;
//	}
}
