package ca.mcgill.ecse321.eventregistration.controller;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ca.mcgill.ecse321.eventregistration.dto.BillDto;
import ca.mcgill.ecse321.eventregistration.dto.CourseDto;
import ca.mcgill.ecse321.eventregistration.dto.EventDto;
import ca.mcgill.ecse321.eventregistration.dto.PersonDto;
import ca.mcgill.ecse321.eventregistration.dto.RegistrationDto;
import ca.mcgill.ecse321.eventregistration.dto.SchoolDto;
import ca.mcgill.ecse321.eventregistration.dto.TutorDto;
import ca.mcgill.ecse321.eventregistration.model.Bill;
import ca.mcgill.ecse321.eventregistration.model.Course;
import ca.mcgill.ecse321.eventregistration.model.Event;
import ca.mcgill.ecse321.eventregistration.model.Person;
import ca.mcgill.ecse321.eventregistration.model.Registration;
import ca.mcgill.ecse321.eventregistration.model.School;
import ca.mcgill.ecse321.eventregistration.model.Tutor;
import ca.mcgill.ecse321.eventregistration.service.EventRegistrationService;

@CrossOrigin(origins = "*")
@RestController
public class EventRegistrationRestController {
	
	@Autowired
	EventRegistrationService service;
	
	//Person post mapping to create it!
		@PostMapping(value = { "/persons/{studentName}", "/persons/{studentName}/" })
		public PersonDto createStudent(	@PathVariable("studentName") String name, 
										@RequestParam("subjectMatter") String email, 
										@RequestParam("Date") String pwd,
										@RequestParam("sessionType") String ID,
										@RequestParam("feedback") boolean isRemoved 
							) throws IllegalArgumentException {
			// @formatter:on
			Person person = service.createStudent(name, email, pwd, ID, isRemoved);
			return convertToDto(person);
		}
		
		//Tutor post mapping to create a tutor
		@PostMapping(value = { "/tutors/{name}", "/tutors/{name}/" })
		public TutorDto createTutor(	@PathVariable("name") String name,
										@RequestParam("email") String email,
										@RequestParam("password") String password,
										@RequestParam("subject") String subject,
										@RequestParam("ID") String ID,
										@RequestParam("hourlyRate") double hourlyRate,
										@RequestParam("availability") String availability
							) throws IllegalArgumentException {
			// @formatter:on
			Tutor person = service.createTutor(name, email, password, ID, false, availability, false, hourlyRate, subject);
			return convertToDto(person);
		}
		
		//Get tutors
		@GetMapping(value = { "/tutors", "/tutors/" })
		public List<Tutor> getAllTutors() {
			List<Tutor> tutorDtos = new ArrayList<>();
			for (Tutor tutor : service.getAllTutors()) {
				tutorDtos.add(tutor);
			}
			return tutorDtos;
		}
		//Get tutors
				@GetMapping(value = { "/bills", "/bills/" })
				public List<Bill> getAllBills() {
					List<Bill> tutorDtos = new ArrayList<>();
					for (Bill tutor : service.getAllBills()) {
						tutorDtos.add(tutor);
					}
					return tutorDtos;
				}
		
		//Get users : 
		@GetMapping(value = { "/persons", "/persons/" })
		public List<Person> getAllPersons() {
			List<Person> personDtos = new ArrayList<>();
			for (Person person : service.getAllPersons()) {
				personDtos.add(person);
			}
			return personDtos;
		}
		
		//Get schools : 
		@GetMapping(value = { "/schools", "/schools/" })
		public List<School> getAllSchools() {
			List<School> schoolDtos = new ArrayList<>();
			for (School school : service.getAllSchools()) {
				schoolDtos.add(school);
			}
			return schoolDtos;
		}
		
		/**
		 * Create a new school in the system.
		 *
		 * @param courseName The name of the school
		 * @return A CourseDto representing the newly added course.
		 * @throws IllegalArgumentException
		 */
		@PostMapping(value = { "/createSchool", "/createSchool/" })
		public SchoolDto createSchool(@RequestParam("schoolName") String name) throws IllegalArgumentException {
			try{
				School school = service.createSchool(name);
				return convertToDto(school);
			}
			catch(Exception e){
				throw new IllegalArgumentException("Could not create course");
			}
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
		 * Create a new course in the system.
		 *
		 * @param courseName The name of the course
		 * @return A CourseDto representing the newly added course.
		 * @throws IllegalArgumentException
		 */
		@PostMapping(value = { "/createBill", "/createBill/" })
		public BillDto createBill(@RequestParam("courseName") String  id, @RequestParam("courseAmount") double  amount, @RequestParam("session_id") String  session_id) throws IllegalArgumentException {
			try{
				Bill bill = service.createBill( amount,id, session_id);
				return convertToDto(bill);
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
		@DeleteMapping(value = { "/deleteCourse", "/deleteCourse/" })
		public boolean deleteCourse(@RequestParam(name = "courseId") String cId) {
			service.deleteCourse(cId);
			return true;
		}
		
		/*@GetMapping(value = { "/events/{name}", "/events/{name}/" })
	public SessionDto getSessionById(@PathVariable("id") int id) throws IllegalArgumentException {
		return convertToDto(service.getSession(id));
	}
	@GetMapping(value = { "/events", "/events/" })
	public List<SessionDto> getAllSessions() {
		List<SessionDto> sessionDtos = new ArrayList<>();
		for (Session session : service.getAllSessions()) {
			sessionDtos.add(convertToDto(session));
		}
		return sessionDtos;
	}

	private SessionDto convertToDto(Session s) {
		if (s == null) {
			throw new IllegalArgumentException("There is no such Event!");
		}
		SessionDto eventDto = new SessionDto(s.getStudent().getName(), s.getStudent().getName(), s.getDate(),s.getStartTime(),s.getEndTime());
		return eventDto;
	}*/

	@PostMapping(value = { "/events/{name}", "/events/{name}/" })
	public EventDto createEvent(@PathVariable("name") String name, @RequestParam Date date,
	@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.TIME, pattern = "HH:mm") LocalTime startTime,
	@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.TIME, pattern = "HH:mm") LocalTime endTime)
	throws IllegalArgumentException {
		Event event = service.createEvent(name, date, Time.valueOf(startTime), Time.valueOf(endTime));
		return convertToDto(event);
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
	
	private CourseDto convertToDto(Course p) {
		if (p == null) {
			throw new IllegalArgumentException("There is no such Person!");
		}
		CourseDto personDto = new CourseDto(p.getNumber());
		return personDto;
	}
	
	private SchoolDto convertToDto(School p) {
		if (p == null) {
			throw new IllegalArgumentException("There is no such Person!");
		}
		SchoolDto schoolDto = new SchoolDto(p.getName());
		return schoolDto;
	}
	private BillDto convertToDto(Bill p) {
		if (p == null) {
			throw new IllegalArgumentException("There is no such Person!");
		}
		BillDto schoolDto = new BillDto();
		return schoolDto;
	}

	private PersonDto convertToDto(Person p) {
		if (p == null) {
			throw new IllegalArgumentException("There is no such Person!");
		}
		PersonDto personDto = new PersonDto(p.getName());
		personDto.setEvents(createEventDtosForPerson(p));
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
	private TutorDto convertToDto(Tutor p) {
		if (p == null) {
			throw new IllegalArgumentException("There is no such Person!");
		}
		TutorDto personDto = new TutorDto(p.getName());
		return personDto;
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
