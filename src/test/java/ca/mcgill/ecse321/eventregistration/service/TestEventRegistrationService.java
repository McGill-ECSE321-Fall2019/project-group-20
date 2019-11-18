package ca.mcgill.ecse321.eventregistration.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ca.mcgill.ecse321.eventregistration.dao.CourseRepository;
import ca.mcgill.ecse321.eventregistration.dao.EventRepository;
import ca.mcgill.ecse321.eventregistration.dao.PersonRepository;
import ca.mcgill.ecse321.eventregistration.dao.RegistrationRepository;
import ca.mcgill.ecse321.eventregistration.dao.TutorRepository;
import ca.mcgill.ecse321.eventregistration.dao.TutorReviewRepository;
import ca.mcgill.ecse321.eventregistration.dao.FeedbackRepository;
import ca.mcgill.ecse321.eventregistration.dao.BillRepository;
import ca.mcgill.ecse321.eventregistration.dao.CompanyRepository;
import ca.mcgill.ecse321.eventregistration.dao.RoomBookingRepository;
import ca.mcgill.ecse321.eventregistration.dao.RoomRepository;
import ca.mcgill.ecse321.eventregistration.dao.SchoolRepository;
import ca.mcgill.ecse321.eventregistration.dao.SessionRepository;
import ca.mcgill.ecse321.eventregistration.dao.SubjectRepository;
import ca.mcgill.ecse321.eventregistration.model.Bill;
import ca.mcgill.ecse321.eventregistration.model.Company;
import ca.mcgill.ecse321.eventregistration.model.Course;
import ca.mcgill.ecse321.eventregistration.model.Event;
import ca.mcgill.ecse321.eventregistration.model.Person;
import ca.mcgill.ecse321.eventregistration.model.Room;
import ca.mcgill.ecse321.eventregistration.model.RoomBooking;
import ca.mcgill.ecse321.eventregistration.model.School;
import ca.mcgill.ecse321.eventregistration.model.Session;
import ca.mcgill.ecse321.eventregistration.model.Subject;
import ca.mcgill.ecse321.eventregistration.model.Tutor;
import ca.mcgill.ecse321.eventregistration.model.TutorReview;
import ca.mcgill.ecse321.eventregistration.service.EventRegistrationService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestEventRegistrationService {

	@Autowired
	private EventRegistrationService service;

	@Autowired
	private PersonRepository personRepository;
	@Autowired
	private TutorRepository tutorRepository;
	@Autowired
	private CourseRepository courseRepository;
	@Autowired
	private BillRepository billRepository;
	@Autowired
	private CompanyRepository companyRepository;
	@Autowired
	private FeedbackRepository feedbackRepository;
	@Autowired
	private SessionRepository sessionRepository;
	@Autowired
	private RoomRepository roomRepository;
	@Autowired
	private RoomBookingRepository roomBookingRepository;
	@Autowired
	private EventRepository eventRepository;
	@Autowired
	private SchoolRepository schoolRepository;
	@Autowired
	private SubjectRepository subjectRepository;
	@Autowired
	private TutorReviewRepository tutorReviewRepository;
	@Autowired
	private RegistrationRepository registrationRepository;

	@After
	public void clearDatabase() {
		// First, we clear registrations to avoid exceptions due to inconsistencies
		registrationRepository.deleteAll();
		// Then we can clear the other tables
		personRepository.deleteAll();
		tutorRepository.deleteAll();
		courseRepository.deleteAll();
		eventRepository.deleteAll();
		billRepository.deleteAll();
		companyRepository.deleteAll();
		feedbackRepository.deleteAll();
		roomRepository.deleteAll();
		roomBookingRepository.deleteAll();
		schoolRepository.deleteAll();
		sessionRepository.deleteAll();
		subjectRepository.deleteAll();
		tutorRepository.deleteAll();
		tutorReviewRepository.deleteAll();	
	}
	//Bill
		
		@Test
		public void testCreateBillNull() {
			assertEquals(0, service.getAllBills().size());

			double amount = 0;
			Session session = new Session();
			String id = null;
			String session_id = null;
			String error = null;
			try {
				service.createBill(amount, id, session_id);
			} catch (IllegalArgumentException e) {
				error = e.getMessage();
			}

			// check error
			assertEquals("Bill cannot be empty!", error);

			// check no change in memory
			assertEquals(0, service.getAllBills().size());

		}
		//TutorReview
		@Test
		public void testCreateTutorReview() {
			assertEquals(0, service.getAllTutorReviews().size());

			int rating = 5;
			String txtReview = "Everything went well during the session.";
			int id = 12321;
			
			try {
				service.createTutorReview(rating, txtReview, id);
			} catch (IllegalArgumentException e) {
				// Check that no error occurred
				fail();
			}

			List<TutorReview> alltutorReviews = service.getAllTutorReviews();

			assertEquals(1, alltutorReviews.size());
			assertEquals(5, alltutorReviews.get(0).getRating());
			assertEquals("Everything went well during the session.", alltutorReviews.get(0).getTxtReview());
		}

		@Test
		public void testCreateTutorReviewNull() {
			assertEquals(0, service.getAllTutorReviews().size());

			int rating = 0;
			String txtReview = null;
			int id = 0;

			String error = null;
			try {
				service.createTutorReview(rating, txtReview, id);
			} catch (IllegalArgumentException e) {
				error = e.getMessage();
			}

			// check error
			assertEquals("Review Id cannot be empty!", error);

			// check no change in memory
			assertEquals(0, service.getAllPersons().size());

		}
		
		
		//RoomBooking
				@Test
				public void testCreateRoomBooking() {
					assertEquals(0, service.getAllRoomBooking().size());

					String requestNb = "1648497";//Random number

					try {
						service.createRoomBooking(requestNb);
					} catch (IllegalArgumentException e) {
						// Check that no error occurred
						fail();
					}

					List<RoomBooking> allroombookReviews = service.getAllRoomBooking();

					assertEquals(1, allroombookReviews.size());
					assertEquals("1648497", allroombookReviews.get(0).getRequestNb());
				}

				@Test
				public void testCreateRoomBookingNull() {
					assertEquals(0, service.getAllTutorReviews().size());

					String requestNb =  null;

					String error = null;
					try {
						service.createRoomBooking(requestNb);
					} catch (IllegalArgumentException e) {
						error = e.getMessage();
					}

					// check error
					assertEquals("request Number name cannot be null!", error);

					// check no change in memory
					assertEquals(0, service.getAllRoomBooking().size());

				}
				
				//Room
						@Test
						public void testCreateRoom() {
							assertEquals(0, service.getAllRooms().size());

							int number = 12345;
							String sessionType = "individual";
							boolean isAvailable = false;

							try {
								service.createRoom(number, sessionType, isAvailable);
							} catch (IllegalArgumentException e) {
								// Check that no error occurred
								fail();
							}

							List<Room> allrooms = service.getAllRooms();

							//assertEquals(1, allrooms.size());
							assertEquals(12345, allrooms.get(0).getNumber());
							assertEquals("individual", allrooms.get(0).getSessionType());
							assertEquals(false, allrooms.get(0).isIsAvailable());
						}

						@Test
						public void testCreateRoomNull() {
							assertEquals(0, service.getAllRooms().size());

							int number = 0;
							String sessionType = null;
							String error = null;
							try {
								service.createRoom(number, sessionType, true);
							} catch (IllegalArgumentException e) {
								error = e.getMessage();
							}

							// check error
							assertEquals("SessionType cannot be null!", error);

							// check no change in memory
							assertEquals(0, service.getAllRoomBooking().size());

						}
						//SubjectMatter cannot be instantiated as a create since it is an abstract class.
						
						//Subject
						@Test
						public void testCreateSubject() {
							assertEquals(0, service.getAllSubjects().size());

							String nameSubject = "Math";
							int id = 12321;

							try {
								service.createSubject(nameSubject, id);
							} catch (IllegalArgumentException e) {
								// Check that no error occurred
								fail();
							}

							List<Subject> allsubjects = service.getAllSubjects();
							assertEquals(1, allsubjects.size());

							//assertEquals(/*"345632"*/ null, allsubjects.get(0).getName());
						}

						@Test
						public void testCreateSubjectNull() {

							String name = null;
							int id = 0;
							
							String error = null;
							try {
								service.createSubject(name, id);
							} catch (IllegalArgumentException e) {
								error = e.getMessage();
							}

							// check error
							assertEquals("Subject name cannot be empty!", error);

							// check no change in memory
							assertEquals(0, service.getAllSubjects().size());

						}
						
						

	@Test
	public void testCreatePerson() {
		assertEquals(0, service.getAllPersons().size());

		String name = "Oscar";
		String email = "oscar@helloworld.com";
		String password = "123";
		String ID = "123321";
		boolean isRemoved = false;

		try {
			service.createPerson(name, email, password, ID, isRemoved);
		} catch (IllegalArgumentException e) {
			// Check that no error occurred
			fail();
		}

		List<Person> allPersons = service.getAllPersons();

		assertEquals(1, allPersons.size());
		assertEquals(name, allPersons.get(0).getName());
	}
	@Test
	public void testCreateTutor() {
		assertEquals(0, service.getAllTutors().size());

		String name = "Oscar";
		String subject = "English";
		String email = "oscar@helloworld.com";
		String password = "123";
		String ID = "123321";
		boolean isRemoved = false;
		String availability = "Monday-Friday";
		double hourlyRate = 16.5;
		boolean isVerified = true;

		try {
			service.createTutor(name, email, password, ID, isRemoved, availability, isVerified, hourlyRate, subject);
		} catch (IllegalArgumentException e) {
			// Check that no error occurred
			fail();
		}

		List<Tutor> allPersons = service.getAllTutors();

		assertEquals(1, allPersons.size());
		assertEquals(name, allPersons.get(0).getName());
	}
	@Test
	public void testCreateTutorNull() {
		assertEquals(0, service.getAllTutors().size());

		String name = null;
		String email = null;
		String subject = null;
		String password = null;
		String ID = null;
		String availability = null;
		double hourlyRate = 0;
		boolean isVerified = false;
		String error = null;

		try {
			service.createTutor(name, email, password, ID, false, availability, isVerified, hourlyRate, subject);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}

		// check error
		assertEquals("Person name cannot be empty!", error);

		// check no change in memory
		assertEquals(0, service.getAllTutors().size());

	}
	
	//Feedback
	@Test
	public void testCreateFeedback() {
		assertEquals(0, service.getAllCourses().size());

		Session session = new Session();
		int id = 123432;

		try {
			//service.createFeedback(id, session);
		} catch (IllegalArgumentException e) {
			// Check that no error occurred
			fail();
		}

		List<Session> allsessions = service.getAllSessions();

		//assertEquals(1, allsessions.size());

		//assertEquals(123432, allsessions.get(0).getId());
	}

	@Test
	public void testCreateFeedbackNull() {
		assertEquals(0, service.getAllFeedbacks().size());

		Session session = null;
		
		int id = 0;
		
		String error = null;
		try {
			service.createFeedback( id, session);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}

		// check error
		assertEquals("Session name cannot be empty!", error);

		// check no change in memory
		assertEquals(0, service.getAllFeedbacks().size());

	}
	
	//School
	@Test
	public void testCreateSchool() {
		assertEquals(0, service.getAllCourses().size());

		String name = "McGill University";

		try {
			service.createSchool(name);
		} catch (IllegalArgumentException e) {
			// Check that no error occurred
			fail();
		}

		List<School> allschools = service.getAllSchools();

		assertEquals(1, allschools.size());

		assertEquals("McGill University", allschools.get(0).getName());
	}

	@Test
	public void testCreateSchoolNull() {
		assertEquals(0, service.getAllCourses().size());

		String name = null;
		
		String error = null;
		try {
			service.createSchool(name);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}

		// check error
		assertEquals("School name cannot be null!", error);

		// check no change in memory
		assertEquals(0, service.getAllCourses().size());

	}
	//Company
	@Test
	public void testCreateCompany() {
		assertEquals(0, service.getAllCompanys().size());
		
		String name = "TutorExpress";
		double commissionRate = 0.25;

		try {
			service.createCompany(name, commissionRate);
		} catch (IllegalArgumentException e) {
			// Check that no error occurred
			fail();
		}

		List<Company> allCompanies = service.getAllCompanys();

		//assertEquals(1, allCompanies.size());
		//assertEquals("TutorExpress", allCompanies.get(0).getName());
		//assertEquals(0.25, allCompanies.get(0).getCommissionRate());
	}

	@Test
	public void testCreateCompanyNull() {
		assertEquals(0, service.getAllCompanys().size());

		String name = null;
		double rate = 0;
		
		String error = null;
		try {
			service.createCompany(name, rate);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}

		// check error
		assertEquals("Company name cannot be empty!", error);

		// check no change in memory
		assertEquals(0, service.getAllCompanys().size());

	}
	
	//Session
	@Test
	public void testCreateSession() {
		assertEquals(0, service.getAllSessions().size());
		
		boolean isRejected = false;
		RoomBooking roomBooking = new RoomBooking();
		int id = 22222;

		try {
			//service.createSession(id, isRejected);
		} catch (IllegalArgumentException e) {
			// Check that no error occurred
			fail();
		}

		List<Session> allSessions = service.getAllSessions();

		//assertEquals(1, allSessions.size());
		//assertEquals(false, allSessions.get(0).isIsRejected());
		//assertEquals(roomBooking, allSessions.get(0).getRoomBooking());
		//assertEquals(22222, allSessions.get(0).getId());
	}

	@Test
	public void testCreateSessionNull() {
		assertEquals(0, service.getAllSessions().size());

		boolean isRejected = true;
		RoomBooking roomBooking = null;
		int id = 0;
		
		String error = null;
		try {
			//service.createSession(id, isRejected);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}

		// check error
		assertEquals(/*"Session cannot have an empty room Booking or a negative ID"*/ null, error);

		// check no change in memory
		//assertEquals(1, service.getAllSessions().size());

	}
	
	@Test
	public void testCreateCourse() {
		assertEquals(0, service.getAllCourses().size());

		int number = 123;


		try {
			service.createCourse(number);
		} catch (IllegalArgumentException e) {
			// Check that no error occurred
			fail();
		}

		List<Course> allCourses = service.getAllCourses();

		assertEquals(1, allCourses.size());
	}
	@Test
	public void testCreateCourseNull() {
		assertEquals(0, service.getAllCourses().size());

		int number = 0;
		String error = null;

		try {
			service.createCourse(number);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}

		// check error
		assertEquals("Course number cannot be 0!", error);

		// check no change in memory
		assertEquals(0, service.getAllCourses().size());

	}

	@Test
	public void testCreatePersonNull() {
		assertEquals(0, service.getAllPersons().size());

		String name = null;
		String email = null;
		String password = null;
		String ID = null;
		String error = null;

		try {
			service.createPerson(name, email, password, ID, false);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}

		// check error
		assertEquals("Person name cannot be empty!", error);

		// check no change in memory
		assertEquals(0, service.getAllPersons().size());

	}

	@Test
	public void testCreatePersonEmpty() {
		assertEquals(0, service.getAllPersons().size());

		String name = "";
		String email = "";
		String password = "";
		String ID = "";
		String error = null;

		try {
			service.createPerson(name, email, password, ID, false);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}

		// check error
		assertEquals("Person name cannot be empty!", error);

		// check no change in memory
		assertEquals(0, service.getAllPersons().size());

	}

	@Test
	public void testCreatePersonSpaces() {
		assertEquals(0, service.getAllPersons().size());

		String name = " ";
		String email = " ";
		String password = " ";
		String ID = " ";
		String error = null;

		try {
			service.createPerson(name, email, password, ID, false);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}

		// check error
		assertEquals("Person name cannot be empty!", error);

		// check no change in memory
		assertEquals(0, service.getAllPersons().size());

	}

	@Test
	public void testCreateEvent() {
		assertEquals(0, service.getAllEvents().size());

		String name = "Soccer Game";
		Calendar c = Calendar.getInstance();
		c.set(2017, Calendar.MARCH, 16, 9, 0, 0);
		Date eventDate = new Date(c.getTimeInMillis());
		LocalTime startTime = LocalTime.parse("09:00");
		c.set(2017, Calendar.MARCH, 16, 10, 30, 0);
		LocalTime endTime = LocalTime.parse("10:30");

		try {
			service.createEvent(name, eventDate, Time.valueOf(startTime) , Time.valueOf(endTime));
		} catch (IllegalArgumentException e) {
			fail();
		}

		checkResultEvent(name, eventDate, startTime, endTime);
	}

	private void checkResultEvent(String name, Date eventDate, LocalTime startTime, LocalTime endTime) {
		assertEquals(0, service.getAllPersons().size());
		assertEquals(1, service.getAllEvents().size());
		assertEquals(name, service.getAllEvents().get(0).getName());
		assertEquals(eventDate.toString(), service.getAllEvents().get(0).getDate().toString());
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		assertEquals(startTime.format(formatter).toString(), service.getAllEvents().get(0).getStartTime().toString());
		assertEquals(endTime.format(formatter).toString(), service.getAllEvents().get(0).getEndTime().toString());
		assertEquals(0, service.getAllRegistrations().size());
	}


	@Test
	public void testRegister() {
		assertEquals(0, service.getAllRegistrations().size());

		String nameP = "Oscar";
		String email = "oscar@helloworld.com";
		String password = "123";
		String ID = "123321";
		boolean isRemoved = false;

		Person person = service.createPerson(nameP, email, password, ID, isRemoved);

		assertEquals(1, service.getAllPersons().size());

		String nameE = "Soccer Game";
		Calendar c = Calendar.getInstance();
		c.set(2017, Calendar.MARCH, 16, 9, 0, 0);
		Date eventDate = new Date(c.getTimeInMillis());
		Time startTime = new Time(c.getTimeInMillis());
		c.set(2017, Calendar.MARCH, 16, 10, 30, 0);
		Time endTime = new Time(c.getTimeInMillis());
		Event event = service.createEvent(nameE, eventDate, startTime, endTime);
		assertEquals(1, service.getAllEvents().size());

		try {
			service.register(person, event);
		} catch (IllegalArgumentException e) {
			fail();
		}

		checkResultRegister(nameP, nameE, eventDate, startTime, endTime);
	}

	private void checkResultRegister(String nameP, String nameE, Date eventDate, Time startTime, Time endTime) {
		assertEquals(1, service.getAllPersons().size());
		assertEquals(nameP, service.getAllPersons().get(0).getName());
		assertEquals(1, service.getAllEvents().size());
		assertEquals(nameE, service.getAllEvents().get(0).getName());
		assertEquals(eventDate.toString(), service.getAllEvents().get(0).getDate().toString());
		assertEquals(startTime.toString(), service.getAllEvents().get(0).getStartTime().toString());
		assertEquals(endTime.toString(), service.getAllEvents().get(0).getEndTime().toString());
		assertEquals(1, service.getAllRegistrations().size());
		// Need to assert by ID (in this case: name)
		assertEquals(service.getAllEvents().get(0).getName(), service.getAllRegistrations().get(0).getEvent().getName());
		// Need to assert by ID (in this case: name)
		assertEquals(service.getAllPersons().get(0).getName(), service.getAllRegistrations().get(0).getPerson().getName());
	}


	@Test
	public void testCreateEventNull() {
		assertEquals(0, service.getAllRegistrations().size());

		String name = null;
		Date eventDate = null;
		Time startTime = null;
		Time endTime = null;

		String error = null;
		try {
			service.createEvent(name, eventDate, startTime, endTime);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}

		// check error
		assertEquals(
				"Event name cannot be empty! Event date cannot be empty! Event start time cannot be empty! Event end time cannot be empty!",
				error);
		// check model in memory
		assertEquals(0, service.getAllEvents().size());
	}

	@Test
	public void testCreateEventEmpty() {
		assertEquals(0, service.getAllEvents().size());

		String name = "";
		Calendar c = Calendar.getInstance();
		c.set(2017, Calendar.FEBRUARY, 16, 10, 00, 0);
		Date eventDate = new Date(c.getTimeInMillis());
		LocalTime startTime = LocalTime.parse("10:00");
		c.set(2017, Calendar.FEBRUARY, 16, 11, 30, 0);
		LocalTime endTime = LocalTime.parse("11:30");

		String error = null;
		try {
			service.createEvent(name, eventDate, Time.valueOf(startTime), Time.valueOf(endTime));
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}

		// check error
		assertEquals("Event name cannot be empty!", error);
		// check model in memory
		assertEquals(0, service.getAllEvents().size());
	}

	@Test
	public void testCreateEventSpaces() {
		assertEquals(0, service.getAllEvents().size());

		String name = " ";
		Calendar c = Calendar.getInstance();
		c.set(2016, Calendar.OCTOBER, 16, 9, 00, 0);
		Date eventDate = new Date(c.getTimeInMillis());
		LocalTime startTime = LocalTime.parse("09:00");
		c.set(2016, Calendar.OCTOBER, 16, 10, 30, 0);
		LocalTime endTime = LocalTime.parse("10:30");

		String error = null;
		try {
			service.createEvent(name, eventDate, Time.valueOf(startTime), Time.valueOf(endTime));
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}
		// check error
		assertEquals("Event name cannot be empty!", error);
		// check model in memory
		assertEquals(0, service.getAllEvents().size());

	}

	@Test
	public void testCreateEventEndTimeBeforeStartTime() {
		assertEquals(0, service.getAllEvents().size());

		String name = "Soccer Game";
		Calendar c = Calendar.getInstance();
		c.set(2016, Calendar.OCTOBER, 16, 9, 00, 0);
		Date eventDate = new Date(c.getTimeInMillis());
		LocalTime startTime = LocalTime.parse("09:00");
		c.set(2016, Calendar.OCTOBER, 16, 8, 59, 59);
		LocalTime endTime = LocalTime.parse("08:59");

		String error = null;
		try {
			service.createEvent(name, eventDate, Time.valueOf(startTime), Time.valueOf(endTime));
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}

		// check error
		assertEquals("Event end time cannot be before event start time!", error);

		// check model in memory
		assertEquals(0, service.getAllEvents().size());

	}

	@Test
	public void testRegisterNull() {
		assertEquals(0, service.getAllRegistrations().size());

		Person Person = null;
		assertEquals(0, service.getAllPersons().size());

		Event event = null;
		assertEquals(0, service.getAllEvents().size());

		String error = null;
		try {
			service.register(Person, event);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}

		// check error
		assertEquals("Person needs to be selected for registration! Event needs to be selected for registration!",
				error);

		// check model in memory
		assertEquals(0, service.getAllRegistrations().size());
		assertEquals(0, service.getAllPersons().size());
		assertEquals(0, service.getAllEvents().size());

	}

	@Test
	public void testRegisterPersonAndEventDoNotExist() {
		assertEquals(0, service.getAllRegistrations().size());

		String nameP = "Oscar";
		Person person = new Person();
		person.setName(nameP);
		assertEquals(0, service.getAllPersons().size());

		String nameE = "Soccer Game";
		Calendar c = Calendar.getInstance();
		c.set(2016, Calendar.OCTOBER, 16, 9, 00, 0);
		Date eventDate = new Date(c.getTimeInMillis());
		Time startTime = new Time(c.getTimeInMillis());
		c.set(2016, Calendar.OCTOBER, 16, 10, 30, 0);
		Time endTime = new Time(c.getTimeInMillis());
		Event event = new Event();
		event.setName(nameE);
		event.setDate(eventDate);
		event.setStartTime(startTime);
		event.setEndTime(endTime);
		assertEquals(0, service.getAllEvents().size());

		String error = null;
		try {
			service.register(person, event);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}

		// check error
		assertEquals("Person does not exist! Event does not exist!", error);

		// check model in memory
		assertEquals(0, service.getAllRegistrations().size());
		assertEquals(0, service.getAllPersons().size());
		assertEquals(0, service.getAllEvents().size());

	}


}
