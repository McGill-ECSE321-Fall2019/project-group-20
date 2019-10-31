package ca.mcgill.ecse321.eventregistration.service;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.mcgill.ecse321.eventregistration.dao.BillRepository;
import ca.mcgill.ecse321.eventregistration.dao.RoomBookingRepository;
import ca.mcgill.ecse321.eventregistration.dao.RoomRepository;
import ca.mcgill.ecse321.eventregistration.dao.CourseRepository;
import ca.mcgill.ecse321.eventregistration.dao.EventRepository;
import ca.mcgill.ecse321.eventregistration.dao.PersonRepository;
import ca.mcgill.ecse321.eventregistration.dao.RegistrationRepository;
import ca.mcgill.ecse321.eventregistration.dao.TutorRepository;
import ca.mcgill.ecse321.eventregistration.model.Bill;
import ca.mcgill.ecse321.eventregistration.model.Course;
import ca.mcgill.ecse321.eventregistration.model.Event;
import ca.mcgill.ecse321.eventregistration.model.Person;
import ca.mcgill.ecse321.eventregistration.model.Registration;
import ca.mcgill.ecse321.eventregistration.model.Room;
import ca.mcgill.ecse321.eventregistration.model.RoomBooking;
import ca.mcgill.ecse321.eventregistration.model.Tutor;

@Service
public class EventRegistrationService {

	@Autowired
	EventRepository eventRepository;
	@Autowired
	PersonRepository personRepository;
	@Autowired
	TutorRepository tutorRepository;
	@Autowired
	BillRepository billRepository;
	@Autowired
	RoomRepository roomRepository;
	@Autowired
	RoomBookingRepository roomBookingRepository;
	@Autowired
	CourseRepository courseRepository;
	@Autowired
	RegistrationRepository registrationRepository;

	@Transactional
	public Person createPerson(String name, String email, String password, String ID, boolean isRemoved) {
		if (name == null || name.trim().length() == 0) {
			throw new IllegalArgumentException("Person name cannot be empty!");
		}
		Person person = new Person();
		person.setName(name);
		person.setEmail(email);
		person.setID(ID);
		person.setPassword(password);
		person.setIsRemoved(false);
		personRepository.save(person);
		return person;
	}

	@Transactional
	public Person getPerson(String name) {
	    if (name == null || name.trim().length() == 0) {
	        throw new IllegalArgumentException("Person name cannot be empty!");
	    }
		Person person = personRepository.findPersonByName(name);
		return person;
	}

	@Transactional
	public List<Person> getAllPersons() {
		return toList(personRepository.findAll());
	}
	
	//Course
	@Transactional
	public Course createCourse(int number) {
		if (number == 0) {
			throw new IllegalArgumentException("Course number cannot be 0!");
		}
		Course course = new Course();
		course.setNumber(number);
		courseRepository.save(course);
		return course;
	}

	@Transactional
	public Course getCourse(int number) {
	    if (number == 0) {
	        throw new IllegalArgumentException("Course number cannot be 0!");
	    }
		Course course = courseRepository.findCourseByNumber(number);
		return course;
	}

	@Transactional
	public List<Course> getAllCourses() {
		return toList(courseRepository.findAll());
	}
	
	//Bills
		@Transactional
		public Bill createBill(double amount) {
			if (amount == 0 ) {
		        throw new IllegalArgumentException("Bill cannot be empty!");
		    }
			Bill bill = new Bill();
			bill.setAmount(amount);
			billRepository.save(bill);
			return bill;
		}

		@Transactional
		public Bill getBill(double amount) {
			Bill bill = billRepository.findBillByAmount(amount);
			return bill;
		}

		@Transactional
		public List<Bill> getAllBills() {
			return toList(billRepository.findAll());
		}
		
		//RoomBooking
		@Transactional
		public RoomBooking createRoomBooking(String requestNb) {
			if (requestNb == null || requestNb.trim().length() == 0 ) {
		        throw new IllegalArgumentException("request Number name cannot be null!");
		    }
			RoomBooking roomBook = new RoomBooking();
			roomBook.setRequestNb(requestNb);
			roomBookingRepository.save(roomBook);
			return roomBook;
		}

		@Transactional
		public RoomBooking getRoomBooking(String requestNb) {
			RoomBooking roomBooking = roomBookingRepository.findRoomBookingByRequestNb(requestNb);
			return roomBooking;
		}

		@Transactional
		public List<RoomBooking> getAllRoomBooking() {
			return toList(roomBookingRepository.findAll());
		}
		
		//Room
		@Transactional
		public Room createRoom(int number, String sessionType, boolean isAvailable) {
			if (sessionType == null || sessionType.trim().length() == 0 ) {
		        throw new IllegalArgumentException("SessionType cannot be null!");
		    }
			Room room = new Room();
			room.setNumber(number);
			room.setSessionType(sessionType);
			room.setIsAvailable(isAvailable);
			roomRepository.save(room);
			return room;
		}

		@Transactional
		public Room getRoom(int number) {
			Room room = roomRepository.findRoomByNumber(number);
			return room;
		}

		@Transactional
		public List<Room> getAllRooms() {
			return toList(roomRepository.findAll());
		}
	
	//Tutor
	@Transactional
	public Tutor createTutor(String name, String email, String password, String ID, boolean isRemoved, String availability, boolean isVerified, double hourlyRate) {
		if (name == null || name.trim().length() == 0) {
			throw new IllegalArgumentException("Person name cannot be empty!");
		}
		Tutor person = new Tutor();
		person.setName(name);
		person.setAvailability(availability);//New
		person.setHourlyRate(hourlyRate);//New
		person.setIsVerified(isVerified);//New
		person.setEmail(email);
		person.setID(ID);
		person.setPassword(password);
		person.setIsRemoved(false);
		tutorRepository.save(person);
		return person;
	}

	@Transactional
	public Tutor getTutor(String name) {
	    if (name == null || name.trim().length() == 0) {
	        throw new IllegalArgumentException("Person name cannot be empty!");
	    }
		Tutor tutor = tutorRepository.findTutorByName(name);
		return tutor;
	}

	@Transactional
	public List<Tutor> getAllTutors() {
		return toList(tutorRepository.findAll());
	}

	@Transactional
	public Event createEvent(String name, Date date, Time startTime, Time endTime) {
	    // Input validation
	    String error = "";
	    if (name == null || name.trim().length() == 0) {
	        error = error + "Event name cannot be empty! ";
	    }
	    if (date == null) {
	        error = error + "Event date cannot be empty! ";
	    }
	    if (startTime == null) {
	        error = error + "Event start time cannot be empty! ";
	    }
	    if (endTime == null) {
	        error = error + "Event end time cannot be empty! ";
	    }
	    if (endTime != null && startTime != null && endTime.before(startTime)) {
	        error = error + "Event end time cannot be before event start time!";
	    }
	    error = error.trim();
	    if (error.length() > 0) {
	        throw new IllegalArgumentException(error);
	    }

		Event event = new Event();
		event.setName(name);
		event.setDate(date);
		event.setStartTime(startTime);
		event.setEndTime(endTime);
		eventRepository.save(event);
		return event;
	}

	@Transactional
	public Event getEvent(String name) {
	    if (name == null || name.trim().length() == 0) {
	        throw new IllegalArgumentException("Event name cannot be empty!");
	    }
		Event event = eventRepository.findEventByName(name);
		return event;
	}

	@Transactional
	public List<Event> getAllEvents() {
		return toList(eventRepository.findAll());
	}

	@Transactional
	public Registration register(Person person, Event event) {
	    String error = "";
	    if (person == null) {
	        error = error + "Person needs to be selected for registration! ";
	    } else if (!personRepository.existsById(person.getName())) {
	        error = error + "Person does not exist! ";
	    }
	    if (event == null) {
	        error = error + "Event needs to be selected for registration!";
	    } else if (!eventRepository.existsById(event.getName())) {
	        error = error + "Event does not exist!";
	    }
	    if (registrationRepository.existsByPersonAndEvent(person, event)) {
	        error = error + "Person is already registered to this event!";
	    }
	    error = error.trim();

	    if (error.length() > 0) {
	        throw new IllegalArgumentException(error);
	    }
		Registration registration = new Registration();
		registration.setId(person.getName().hashCode() * event.getName().hashCode());
		registration.setPerson(person);
		registration.setEvent(event);

		registrationRepository.save(registration);

		return registration;
	}

	@Transactional
	public List<Registration> getAllRegistrations(){
		return toList(registrationRepository.findAll());
	}

	@Transactional
	public List<Event> getEventsAttendedByPerson(Person person) {
	    if (person == null ) {
	        throw new IllegalArgumentException("Person cannot be null!");
	    }
	    List<Event> eventsAttendedByPerson = new ArrayList<>();
	    for (Registration r : registrationRepository.findByPerson(person)) {
	        eventsAttendedByPerson.add(r.getEvent());
	    }
	    return eventsAttendedByPerson;
	}

	private <T> List<T> toList(Iterable<T> iterable){
		List<T> resultList = new ArrayList<T>();
		for (T t : iterable) {
			resultList.add(t);
		}
		return resultList;
	}

}