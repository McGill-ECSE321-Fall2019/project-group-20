package ca.mcgill.ecse321.eventregistration.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import ca.mcgill.ecse321.eventregistration.dao.BillRepository;
import ca.mcgill.ecse321.eventregistration.dao.CompanyRepository;
import ca.mcgill.ecse321.eventregistration.dao.CourseRepository;
import ca.mcgill.ecse321.eventregistration.dao.EventRepository;
import ca.mcgill.ecse321.eventregistration.dao.FeedbackRepository;
import ca.mcgill.ecse321.eventregistration.dao.PersonRepository;
import ca.mcgill.ecse321.eventregistration.dao.RegistrationRepository;
import ca.mcgill.ecse321.eventregistration.dao.RoomBookingRepository;
import ca.mcgill.ecse321.eventregistration.dao.RoomRepository;
import ca.mcgill.ecse321.eventregistration.dao.SchoolRepository;
import ca.mcgill.ecse321.eventregistration.dao.SessionRepository;
import ca.mcgill.ecse321.eventregistration.dao.SubjectRepository;
import ca.mcgill.ecse321.eventregistration.dao.TutorRepository;
import ca.mcgill.ecse321.eventregistration.dao.TutorReviewRepository;
import ca.mcgill.ecse321.eventregistration.model.Bill;
import ca.mcgill.ecse321.eventregistration.model.Company;
import ca.mcgill.ecse321.eventregistration.model.Course;
import ca.mcgill.ecse321.eventregistration.model.Event;
import ca.mcgill.ecse321.eventregistration.model.Feedback;
import ca.mcgill.ecse321.eventregistration.model.Person;
import ca.mcgill.ecse321.eventregistration.model.Registration;
import ca.mcgill.ecse321.eventregistration.model.Room;
import ca.mcgill.ecse321.eventregistration.model.RoomBooking;
import ca.mcgill.ecse321.eventregistration.model.School;
import ca.mcgill.ecse321.eventregistration.model.Session;
import ca.mcgill.ecse321.eventregistration.model.Subject;
import ca.mcgill.ecse321.eventregistration.model.Tutor;
import ca.mcgill.ecse321.eventregistration.model.TutorReview;

@RunWith(MockitoJUnitRunner.Silent.class)
public class ServiceTests {

	@Mock
	private PersonRepository personDao;
	
	@Mock
	private TutorRepository tutorDao;
	
	@Mock
	private CourseRepository courseDao;
	
	@Mock
	private RoomRepository roomDao;
	
	@Mock
	private CompanyRepository companyDao;
	
	@Mock
	private SchoolRepository schoolDao;
	
	@Mock
	private RoomBookingRepository roomBookingDao;
	
	@Mock
	private BillRepository billDao;
	
	@Mock
	private FeedbackRepository feedbackDao;
	
	@Mock
	private SessionRepository sessionDao;
	
	@Mock
	private SubjectRepository subjectDao;
	
	@Mock
	private TutorReviewRepository tutorReviewDao;

	@Mock
	private RegistrationRepository registrationDao;

	@Mock
	private EventRepository eventDao;

	@InjectMocks
	private EventRegistrationService service;

	private static final String PERSON_KEY = "TestPerson";
	private static final String NONEXISTING_KEY = "NotAPerson";
	private Person person;
	private Tutor tutor;
	private Course course;
	private Event event;
	private Bill bill;
	private Company company;
	private RoomBooking roomBooking;
	private Room room;
	private School school;
	private Feedback feedback;
	private Session session;
	private Subject subject;
	private TutorReview tutorReview;
	private Registration registration;

	@Before
	public void setMockOutput() {
		when(personDao.findById((anyString()))).thenAnswer((InvocationOnMock invocation) -> {
			if (invocation.getArgument(0).equals(PERSON_KEY)) {
				Person person = new Person();
				person.setName(PERSON_KEY);
				return person;
			} else {
				return null;
			}
		});
		// Whenever anything is saved, just return the parameter object
		Answer<?> returnParameterAsAnswer = (InvocationOnMock invocation) -> {
			return invocation.getArgument(0);
		};
		when(personDao.save(any(Person.class))).thenAnswer(returnParameterAsAnswer);
		when(tutorDao.save(any(Tutor.class))).thenAnswer(returnParameterAsAnswer);
		when(courseDao.save(any(Course.class))).thenAnswer(returnParameterAsAnswer);
		when(eventDao.save(any(Event.class))).thenAnswer(returnParameterAsAnswer);
		when(roomDao.save(any(Room.class))).thenAnswer(returnParameterAsAnswer);
		when(billDao.save(any(Bill.class))).thenAnswer(returnParameterAsAnswer);
		when(companyDao.save(any(Company.class))).thenAnswer(returnParameterAsAnswer);
		when(roomBookingDao.save(any(RoomBooking.class))).thenAnswer(returnParameterAsAnswer);
		when(feedbackDao.save(any(Feedback.class))).thenAnswer(returnParameterAsAnswer);
		when(sessionDao.save(any(Session.class))).thenAnswer(returnParameterAsAnswer);
		when(subjectDao.save(any(Subject.class))).thenAnswer(returnParameterAsAnswer);
		when(tutorReviewDao.save(any(TutorReview.class))).thenAnswer(returnParameterAsAnswer);
		
		when(registrationDao.save(any(Registration.class))).thenAnswer(returnParameterAsAnswer);
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
			person = service.createPerson(name, email, password, ID, isRemoved);
		} catch (IllegalArgumentException e) {
			// Check that no error occurred
			fail();
		}

		assertEquals(name, person.getName());
	}
	@Test
	public void testCreateTutor() {
		assertEquals(0, service.getAllTutors().size());

		String name = "Oscar";
		String subject = "English";
		String email = "oscar@helloworld.com";
		String password = "123";
		String ID = "123321";
		String availability = "Monday-Friday";
		double hourlyRate = 16.5;
		boolean isVerified = true;
		boolean isRemoved = false;

		try {
			tutor = service.createTutor(name, email, password, ID, isRemoved, availability, isVerified, hourlyRate, subject);
		} catch (IllegalArgumentException e) {
			// Check that no error occurred
			fail();
		}

		assertEquals(name, tutor.getName());
	}
	
	@Test
	public void testCreateFeedback() {
		assertEquals(0, service.getAllFeedbacks().size());

		int ID = 12321;
		Session session = new Session();

		try {
			feedback = service.createFeedback(ID, session);
		} catch (IllegalArgumentException e) {
			// Check that no error occurred
			fail();
		}

		assertEquals(ID, feedback.getId());
	}
	@Test
	public void testCreateFeedbackNull() {
		int Id = 0;
		Session session = new Session();
		String error = null;

		try {
			feedback = service.createFeedback(Id, session);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}

		// check error
		assertEquals("Session name cannot be empty!", error);
	}
	
	//TutorReview
	@Test
	public void testCreateTutorReview() {
		assertEquals(0, service.getAllTutorReviews().size());
		
		int id = 12321;
		int rating = 4;
		String txtReview = "Awesome session!";

		try {
			tutorReview = service.createTutorReview(rating, txtReview, id);
		} catch (IllegalArgumentException e) {
			// Check that no error occurred
			fail();
		}

		assertEquals(rating, tutorReview.getRating());
	}
	@Test
	public void testCreateTutorReviewNull() {
		int id = 0;
		int rating = 0;
		String txtReview = null;
		String error = null;


		try {
			tutorReview = service.createTutorReview(rating, txtReview, id);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}

		// check error
		assertEquals("Review Id cannot be empty!", error);
	}
	
	//Subject
	@Test
	public void testCreateSubject() {
		assertEquals(0, service.getAllSubjects().size());

		int ID = 12321;
		String name = "Human";

		try {
			subject = service.createSubject(name, ID);
		} catch (IllegalArgumentException e) {
			// Check that no error occurred
			fail();
		}

		assertEquals(ID, subject.getId());
	}
	@Test
	public void testCreateSubjectNull() {
		int Id = 0;
		String name = null;
		String error = null;

		try {
			subject = service.createSubject(name, Id);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}

		// check error
		assertEquals("Subject name cannot be empty!", error);
	}
	
	
	//Session
	@Test
	public void testCreateSession() {
		assertEquals(0, service.getAllSessions().size());

		int ID = 12321;
		boolean isRejected = false;

		try {
			session = service.createSession(ID, isRejected);
		} catch (IllegalArgumentException e) {
			// Check that no error occurred
			fail();
		}

		assertEquals(ID, session.getId());
	}
	@Test
	public void testCreateSessionNull() {
		int Id = 0;
		boolean isRejected = true;
		String error = null;

		try {
			session = service.createSession(Id, isRejected);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}

		// check error
		assertEquals("Session name cannot be empty!", error);
	}
	@Test
	public void testCreateTutorNull() {
		String name = null;
		String email = null;
		String password = null;
		String ID = null;
		String availability = null;
		String subject = null;
		double hourlyRate = 0;
		boolean isVerified = false;
		String error = null;

		try {
			tutor = service.createTutor(name, email, password, ID, false, availability, isVerified, hourlyRate, subject);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}

		// check error
		assertEquals("Person name cannot be empty!", error);
	}
	
	
	//Company
	@Test
	public void testCreateCompany() {
		assertEquals(0, service.getAllCompanys().size());

		String name = "Oscar";
		double commissionRate = 10.5;

		try {
			company = service.createCompany(name, commissionRate);
		} catch (IllegalArgumentException e) {
			// Check that no error occurred
			fail();
		}

		assertEquals(name, company.getName());
	}
	@Test
	public void testCreateCompanyNull() {
		String name = null;
		double commissionRate = 0;
		String error = null;
		

		try {
			company = service.createCompany(name, commissionRate);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}

		// check error
		assertEquals("Company name cannot be empty!", error);
	}
	
	
	//Course
	@Test
	public void testCreateCourse() {
		assertEquals(0, service.getAllCourses().size());

		int number = 212;

		try {
			course = service.createCourse(number);
		} catch (IllegalArgumentException e) {
			// Check that no error occurred
			fail();
		}

		assertEquals(number, course.getNumber());
	}
	@Test
	public void testCreateCourseNull() {
		int number = 0;
		String error = null;

		try {
			course = service.createCourse(number);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}

		// check error
		assertEquals("Course number cannot be 0!", error);
	}
	
	//Room
	@Test
	public void testCreateRoom() {
		assertEquals(0, service.getAllRooms().size());

		int number = 12345;
		String sessionType = "individual";
		boolean isAvailable = false;

		try {
			room = service.createRoom(number, sessionType, isAvailable);
		} catch (IllegalArgumentException e) {
			// Check that no error occurred
			fail();
		}

		assertEquals(number, room.getNumber());
	}
	@Test
	public void testCreateRoomNull() {
		int number = 0;
		String sessionType = null;
		String error = null;

		try {
			room = service.createRoom(number, sessionType, false);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}

		// check error
		assertEquals("SessionType cannot be null!", error);
	}
	
	//School
		@Test
		public void testCreateSchool() {
			assertEquals(0, service.getAllSchools().size());

			String name = "McGill University";

			try {
				school = service.createSchool(name);
			} catch (IllegalArgumentException e) {
				// Check that no error occurred
				fail();
			}

			assertEquals(name, school.getName());
		}
		@Test
		public void testCreateSchoolNull() {
			String name = null;
			String error = null;

			try {
				school = service.createSchool(name);
			} catch (IllegalArgumentException e) {
				error = e.getMessage();
			}

			// check error
			assertEquals("School name cannot be null!", error);
		}
		
		//RoomBooking
				@Test
				public void testCreateRoomBooking() {
					assertEquals(0, service.getAllRoomBooking().size());

					String name = "Request1";

					try {
						roomBooking = service.createRoomBooking(name);
					} catch (IllegalArgumentException e) {
						// Check that no error occurred
						fail();
					}

					assertEquals(name, roomBooking.getRequestNb());
				}
				@Test
				public void testCreateRoomBookingNull() {
					String name = null;
					String error = null;

					try {
						roomBooking = service.createRoomBooking(name);
					} catch (IllegalArgumentException e) {
						error = e.getMessage();
					}

					// check error
					assertEquals("request Number name cannot be null!", error);
				}
	
	//Bill
	@Test
	public void testCreateBill() {
		assertEquals(0, service.getAllBills().size());

		double amount = 212;
		String id = "123";
		String session_id = "321";

		try {
			bill = service.createBill(amount, id, session_id);
		} catch (IllegalArgumentException e) {
			// Check that no error occurred
			fail();
		}

	}
	@Test
	public void testCreateBillnull() {
		double number = 0;
		String error = null;
		String id = null;
		String session_id = null;

		try {
			bill = service.createBill(number, id, session_id);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}

		// check error
		assertEquals("Bill cannot be empty!", error);
	}
	
	//Person
	@Test
	public void testCreatePersonNull() {
		String name = null;
		String email = null;
		String password = null;
		String ID = null;
		String error = null;

		try {
			person = service.createPerson(name, email, password, ID, false);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}

		// check error
		assertEquals("Person name cannot be empty!", error);
	}

	@Test
	public void testCreatePersonEmpty() {
		String name = "";
		String email = "";
		String password = "";
		String ID = "";
		String error = null;

		try {
			person = service.createPerson(name, email, password, ID, false);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}

		// check error
		assertEquals("Person name cannot be empty!", error);
	}

	@Test
	public void testCreatePersonSpaces() {

		String name = " ";
		String email = " ";
		String password = " ";
		String ID = " ";
		String error = null;

		try {
			person = service.createPerson(name, email, password, ID, false);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}

		// check error
		assertEquals("Person name cannot be empty!", error);
	}

	@Test
	public void testCreateEvent() {
		String name = "Soccer Game";
		Calendar c = Calendar.getInstance();
		c.set(2017, Calendar.MARCH, 16, 9, 0, 0);
		Date eventDate = new Date(c.getTimeInMillis());
		LocalTime startTime = LocalTime.parse("09:00");
		c.set(2017, Calendar.MARCH, 16, 10, 30, 0);
		LocalTime endTime = LocalTime.parse("10:30");

		try {
			event = service.createEvent(name, eventDate, Time.valueOf(startTime), Time.valueOf(endTime));
		} catch (IllegalArgumentException e) {
			fail();
		}

		checkResultEvent(name, eventDate, startTime, endTime);
	}

	private void checkResultEvent(String name, Date eventDate, LocalTime startTime, LocalTime endTime) {
		assertEquals(name, event.getName());
		assertEquals(eventDate.toString(), event.getDate().toString());
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		assertEquals(startTime.format(formatter).toString(), event.getStartTime().toString());
		assertEquals(endTime.format(formatter).toString(), event.getEndTime().toString());
	}

	@Test
	public void testRegister() {
		String nameP = "Oscar2";
		String email = "oscar@mail.mcgill.ca";
		String password = "111";
		String ID = "222";
		String nameE = "Soccer Game2";
		Calendar c = Calendar.getInstance();
		c.set(2017, Calendar.MARCH, 16, 9, 0, 0);
		Date eventDate = new Date(c.getTimeInMillis());
		Time startTime = new Time(c.getTimeInMillis());
		c.set(2017, Calendar.MARCH, 16, 10, 30, 0);
		Time endTime = new Time(c.getTimeInMillis());
		person = service.createPerson(nameP, email, password, ID, false);
		event = service.createEvent(nameE, eventDate, startTime, endTime);
		when(personDao.existsById(anyString())).thenReturn(true);
		when(eventDao.existsById(anyString())).thenReturn(true);
		try {
			registration = service.register(person, event);
		} catch (IllegalArgumentException e) {
			fail();
		}

		checkResultRegister(nameP, nameE, eventDate, startTime, endTime);
	}

	private void checkResultRegister(String nameP, String nameE, Date eventDate, Time startTime, Time endTime) {

		assertEquals(nameP, registration.getPerson().getName());
		assertEquals(nameE, registration.getEvent().getName());
		assertEquals(eventDate.toString(), registration.getEvent().getDate().toString());
		assertEquals(startTime.toString(), registration.getEvent().getStartTime().toString());
		assertEquals(endTime.toString(), registration.getEvent().getEndTime().toString());
	}

	@Test
	public void testCreateEventNull() {
		String name = null;
		Date eventDate = null;
		Time startTime = null;
		Time endTime = null;

		String error = null;
		try {
			event = service.createEvent(name, eventDate, startTime, endTime);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}

		// check error
		assertEquals(
				"Event name cannot be empty! Event date cannot be empty! Event start time cannot be empty! Event end time cannot be empty!",
				error);
	}

	@Test
	public void testCreateEventEmpty() {
		String name = "";
		Calendar c = Calendar.getInstance();
		c.set(2017, Calendar.FEBRUARY, 16, 10, 00, 0);
		Date eventDate = new Date(c.getTimeInMillis());
		LocalTime startTime = LocalTime.parse("10:00");
		c.set(2017, Calendar.FEBRUARY, 16, 11, 30, 0);
		LocalTime endTime = LocalTime.parse("11:30");

		String error = null;
		try {
			event = service.createEvent(name, eventDate, Time.valueOf(startTime), Time.valueOf(endTime));
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}

		// check error
		assertEquals("Event name cannot be empty!", error);
	}

	@Test
	public void testCreateEventSpaces() {
		String name = " ";
		Calendar c = Calendar.getInstance();
		c.set(2016, Calendar.OCTOBER, 16, 9, 00, 0);
		Date eventDate = new Date(c.getTimeInMillis());
		LocalTime startTime = LocalTime.parse("09:00");
		c.set(2016, Calendar.OCTOBER, 16, 10, 30, 0);
		LocalTime endTime = LocalTime.parse("10:30");

		String error = null;
		try {
			event = service.createEvent(name, eventDate, Time.valueOf(startTime), Time.valueOf(endTime));
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}
		// check error
		assertEquals("Event name cannot be empty!", error);
	}

	@Test
	public void testCreateEventEndTimeBeforeStartTime() {
		String name = "Soccer Game";
		Calendar c = Calendar.getInstance();
		c.set(2016, Calendar.OCTOBER, 16, 9, 00, 0);
		Date eventDate = new Date(c.getTimeInMillis());
		LocalTime startTime = LocalTime.parse("09:00");
		c.set(2016, Calendar.OCTOBER, 16, 8, 59, 59);
		LocalTime endTime = LocalTime.parse("08:59");

		String error = null;
		try {
			event = service.createEvent(name, eventDate, Time.valueOf(startTime), Time.valueOf(endTime));
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}

		// check error
		assertEquals("Event end time cannot be before event start time!", error);
	}

	@Test
	public void testRegisterNull() {
		Person Person = null;
		assertEquals(0, service.getAllPersons().size());

		Event event = null;
		assertEquals(0, service.getAllEvents().size());

		String error = null;
		try {
			registration = service.register(Person, event);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}

		// check error
		assertEquals("Person needs to be selected for registration! Event needs to be selected for registration!",
				error);
	}

	@Test
	public void testRegisterPersonAndEventDoNotExist() {
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
			registration = service.register(person, event);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}

		// check error
		assertEquals("Person does not exist! Event does not exist!", error);
	}

	@Test
	public void testGetExistingPerson() {
		//assertEquals(PERSON_KEY, service.getPerson(PERSON_KEY).getName());
	}

	@Test
	public void testGetNonExistingPerson() {
		assertNull(service.getPerson(NONEXISTING_KEY));
	}
}
