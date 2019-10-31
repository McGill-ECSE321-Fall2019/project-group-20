package ca.mcgill.ecse321.eventregistration.controller;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ca.mcgill.ecse321.eventregistration.dto.CourseDto;
import ca.mcgill.ecse321.eventregistration.dto.EventDto;
import ca.mcgill.ecse321.eventregistration.dto.PersonDto;
import ca.mcgill.ecse321.eventregistration.dto.RegistrationDto;
import ca.mcgill.ecse321.eventregistration.dto.TutorDto;
import ca.mcgill.ecse321.eventregistration.model.Course;
import ca.mcgill.ecse321.eventregistration.model.Event;
import ca.mcgill.ecse321.eventregistration.model.Person;
import ca.mcgill.ecse321.eventregistration.model.Registration;
import ca.mcgill.ecse321.eventregistration.model.Tutor;
import ca.mcgill.ecse321.eventregistration.service.EventRegistrationService;

@CrossOrigin(origins = "*")
@RestController
public class EventRegistrationRestController {
	
	@Autowired
	EventRegistrationService service;
	
	@PostMapping(value = { "/persons/{name}", "/persons/{name}/" })
	public PersonDto createPerson(@PathVariable("name") String name) throws IllegalArgumentException {
		// @formatter:on
		String tmp = "tmp"; //tmp variable until I get the data from Adam
		Person person = service.createPerson(name, tmp, tmp, tmp, false);
		return convertToDto(person);
	}
	@PostMapping(value = { "/tutors/{name}", "/tutors/{name}/" })
	public TutorDto createTutor(@PathVariable("name") String name) throws IllegalArgumentException {
		// @formatter:on
		String tmp = "tmp"; //tmp variable until I get the data from Adam
		Tutor person = service.createTutor(name, tmp, tmp, tmp, false, tmp, false, 1);
		return convertToDto(person);
	}

	@PostMapping(value = { "/events/{name}", "/events/{name}/" })
	public EventDto createEvent(@PathVariable("name") String name, @RequestParam Date date,
	@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.TIME, pattern = "HH:mm") LocalTime startTime,
	@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.TIME, pattern = "HH:mm") LocalTime endTime)
	throws IllegalArgumentException {
		Event event = service.createEvent(name, date, Time.valueOf(startTime), Time.valueOf(endTime));
		return convertToDto(event);
	}
	/**
	 * Create a new course in the system.
	 *
	 * @param courseName The name of the course
	 * @return A CourseDto representing the newly added course.
	 * @throws IllegalArgumentException
	 */
	@PostMapping(value = { "/createCourse", "/createCourse/" })
	public CourseDto createCourse(@RequestParam("courseName") int courseNumber) throws IllegalArgumentException {
		try{
			Course course = service.createCourse(courseNumber);
			return convertToDto(course);
		}
		catch(Exception e){
			throw new IllegalArgumentException("Could not create course");
		}
	}

	/**
	 * View all courses in the system
	 *
	 * @return a list of CourseDto representing all courses in the system.
	 */
	@GetMapping(value = { "/allCourses", "/allCourses/" })
	public List<CourseDto> getAllCourses() {
		try {
			List<CourseDto> coursesDto = new ArrayList<>();
			for (Course course : service.getAllCourses()) {
				coursesDto.add(convertToDto(course));
			}
			return coursesDto;
		}
		catch(Exception e) {
			throw new IllegalArgumentException("Could not retrieve information from service");
		}
	}
	
	/**
	 * Delete a course
	 * 
	 * @param cId course id
	 * @return true if success
	 */
	@PostMapping(value = { "/deleteCourse", "/deleteCourse/" })
	public boolean deleteDocument(@RequestParam(name = "courseId") int cId) {
		service.deleteCourse(cId);
		return true;
	}

	@GetMapping(value = { "/events", "/events/" })
	public List<EventDto> getAllEvents() {
		List<EventDto> eventDtos = new ArrayList<>();
		for (Event event : service.getAllEvents()) {
			eventDtos.add(convertToDto(event));
		}
		return eventDtos;
	}

	@PostMapping(value = { "/register", "/register/" })
	public RegistrationDto registerPersonForEvent(@RequestParam(name = "person") PersonDto pDto,
		@RequestParam(name = "event") EventDto eDto) throws IllegalArgumentException {
		Person p = service.getPerson(pDto.getName());
		Event e = service.getEvent(eDto.getName());

		Registration r = service.register(p, e);
		return convertToDto(r, p, e);
	}

	@GetMapping(value = { "/registrations/person/{name}", "/registrations/person/{name}/" })
	public List<EventDto> getEventsOfPerson(@PathVariable("name") PersonDto pDto) {
		Person p = convertToDomainObject(pDto);
		return createEventDtosForPerson(p);
	}

	@GetMapping(value = { "/events/{name}", "/events/{name}/" })
	public EventDto getEventByName(@PathVariable("name") String name) throws IllegalArgumentException {
		return convertToDto(service.getEvent(name));
	}

	private EventDto convertToDto(Event e) {
		if (e == null) {
			throw new IllegalArgumentException("There is no such Event!");
		}
		EventDto eventDto = new EventDto(e.getName(),e.getDate(),e.getStartTime(),e.getEndTime());
		return eventDto;
	}

	private PersonDto convertToDto(Person p) {
		if (p == null) {
			throw new IllegalArgumentException("There is no such Person!");
		}
		PersonDto personDto = new PersonDto(p.getName());
		personDto.setEvents(createEventDtosForPerson(p));
		return personDto;
	}
	private CourseDto convertToDto(Course p) {
		if (p == null) {
			throw new IllegalArgumentException("There is no such Person!");
		}
		CourseDto personDto = new CourseDto(p.getNumber());
		return personDto;
	}
	private TutorDto convertToDto(Tutor p) {
		if (p == null) {
			throw new IllegalArgumentException("There is no such Person!");
		}
		TutorDto personDto = new TutorDto(p.getName());
		return personDto;
	}

	private RegistrationDto convertToDto(Registration r, Person p, Event e) {
		EventDto eDto = convertToDto(e);
		PersonDto pDto = convertToDto(p);
		return new RegistrationDto(pDto, eDto);
	}

	private Person convertToDomainObject(PersonDto pDto) {
		List<Person> allPersons = service.getAllPersons();
		for (Person person : allPersons) {
			if (person.getName().equals(pDto.getName())) {
				return person;
			}
		}
		return null;
	}

	private List<EventDto> createEventDtosForPerson(Person p) {
		List<Event> eventsForPerson = service.getEventsAttendedByPerson(p);
		List<EventDto> events = new ArrayList<>();
		for (Event event : eventsForPerson) {
			events.add(convertToDto(event));
		}
		return events;
	}
	
}
