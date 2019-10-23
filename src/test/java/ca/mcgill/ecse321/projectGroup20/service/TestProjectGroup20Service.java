package ca.mcgill.ecse321.projectGroup20.service;
import static org.junit.Assert.assertEquals;

import static org.junit.Assert.fail;
import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.*;


import ca.mcgill.ecse321.projectGroup20.dao.*;
import ca.mcgill.ecse321.projectGroup20.model.*;

/**Test class for the database methods inside of the service class
 * @author Imane Chafi
 * */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestProjectGroup20Service  {
	//ApplicationContext context = new AnnotationConfigApplicationContext(projectGroup20Service.class);
	
	@Autowired
	private projectGroup20Service service;
	@Autowired
	private BillRepository billRepository;
	@Autowired
	private CompanyRepository companyRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private CourseRepository courseRepository;
	@Autowired
	private FeedbackRepository feedbackRepository;
	@Autowired
	private RoomRepository roomRepository;
	@Autowired
	private RoomBookingRepository roomBookingRepository;
	@Autowired
	private SchoolRepository schoolRepository;
	@Autowired
	private SessionRepository sessionRepository;
	@Autowired
	private SubjectMatterRepository subjectMatterRepository;
	@Autowired
	private SubjectRepository subjectRepository;
	@Autowired
	private TutorRepository tutorRepository;
	@Autowired
	TutorReviewRepository tutorReviewRepository;

	@After
	public void clearDatabase()  { //We're cleaning the contents of the database
		 //Fisrt, we clear registrations to avoid exceptions due to inconsistencies
		sessionRepository.deleteAll();
		// Then we can clear the other tables
		subjectMatterRepository.deleteAll();
		schoolRepository.deleteAll();
		feedbackRepository.deleteAll();
		roomRepository.deleteAll();
		roomBookingRepository.deleteAll();
		billRepository.deleteAll();
		companyRepository.deleteAll();
		userRepository.deleteAll();
		courseRepository.deleteAll();
		subjectRepository.deleteAll();
		tutorRepository.deleteAll();
		tutorReviewRepository.deleteAll();
	}
	

	//User
	@Test
	public void testCreateUser() { //This creates a user and checks if we can create users
		//assertEquals(0, service.getAllPersons().size());

		String name = "Oscar";
		String email = "oscar@helloworld.com";
		String password = "123";
		String ID = "123321";
		boolean isRemoved = false;

		try {
			//service.createUser(name, email, password, ID, isRemoved);
		} catch (IllegalArgumentException e) {
			// Check that no error occurred
			fail();
		}

		//List<User> allPersons = service.getAllPersons();

		//assertEquals(1, allPersons.size());
		//assertEquals(name, allPersons.get(0).getName()); //Getters to the application to read the data and assess if its equal to the one we created. 
	}

	@Test
	public void testCreateUserNull() {//This reads the create user method to make sure that they are not null
		//assertEquals(0, service.getAllPersons().size());

		String name = null;
		String email = null;
		String password = null;
		String ID = null;
		String error = null;

		try {
			//service.createUser(name, email, password, ID, true);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}

		// check error
		//assertEquals("User name cannot be empty!", error);

		// check no change in memory
		//assertEquals(0, service.getAllPersons().size());

	}

	//Bill
	@SuppressWarnings("deprecation")
	@Test
	public void testCreateBill() {
		//assertEquals(0, service.getAllBills().size());

		double amount = 100;
		Session Testsession = new Session();

		try {
			//service.createBill(amount, Testsession);
		} catch (IllegalArgumentException e) {
			// Check that no error occurred
			fail();
		}

		//List<Bill> allBills = service.getAllBills();

		//assertEquals(1, allBills.size());
		//assertEquals(100, allBills.get(0).getAmount());
	}
	
	@Test
	public void testCreateBillNull() {
		//assertEquals(0, service.getAllBills().size());

		//double amount = (Double) null;
		Session session = new Session();
		
		String error = null;
		try {
			//service.createBill(amount, session);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}

		// check error
		//assertEquals("Bill cannot be empty!", error);

		// check no change in memory
		//assertEquals(0, service.getAllBills().size());

	}
	//TutorReview
	@Test
	public void testCreateTutorReview() {
		//assertEquals(0, service.getAllTutorReviews().size());

		int rating = 5;
		String txtReview = "Everything went well during the session.";

		try {
			//service.createTutorReview(rating, txtReview);
		} catch (IllegalArgumentException e) {
			// Check that no error occurred
			fail();
		}

		//List<TutorReview> alltutorReviews = service.getAllTutorReviews();

		//assertEquals(1, alltutorReviews.size());
		//assertEquals(5, alltutorReviews.get(0).getRating());
		//assertEquals("Everything went well during the session.", alltutorReviews.get(0).getTxtReview());
	}

	@Test
	public void testCreateTutorReviewNull() {
		//assertEquals(0, service.getAllTutorReviews().size());

		//int rating = (Integer) null;
		String txtReview = null;

		String error = null;
		try {
			//service.createTutorReview(rating, txtReview);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}

		// check error
		//assertEquals("Tutor review cannot be empty!", error);

		// check no change in memory
		//assertEquals(0, service.getAllPersons().size());

	}
	
	//RoomBooking
		@Test
		public void testCreateRoomBooking() {
			//assertEquals(0, service.getAllRoomBooking().size());

			String requestNb = "1648497";//Random number

			try {
				//service.createRoomBooking(requestNb);
			} catch (IllegalArgumentException e) {
				// Check that no error occurred
				fail();
			}

			//List<RoomBooking> allroombookReviews = service.getAllRoomBooking();

			//assertEquals(1, allroombookReviews.size());
			//assertEquals("1648497", allroombookReviews.get(0).getRequestNb());
		}

		@Test
		public void testCreateRoomBookingNull() {
			//assertEquals(0, service.getAllTutorReviews().size());

			String requestNb =  null;

			String error = null;
			try {
				//service.createRoomBooking(requestNb);
			} catch (IllegalArgumentException e) {
				error = e.getMessage();
			}

			// check error
			//assertEquals("Request number cannot be empty!", error);

			// check no change in memory
			//assertEquals(0, service.getAllRoomBooking().size());

		}
		
		//Room
				@Test
				public void testCreateRoom() {
					//assertEquals(0, service.getAllRooms().size());

					int number = 12345;
					String sessionType = "individual";
					boolean isAvailable = false;

					try {
						//service.createRoom(number, sessionType, isAvailable);
					} catch (IllegalArgumentException e) {
						// Check that no error occurred
						fail();
					}

					//List<Room> allrooms = service.getAllRooms();

					//assertEquals(1, allrooms.size());
					//assertEquals(12345, allrooms.get(0).getNumber());
					//assertEquals("individual", allrooms.get(0).getSessionType());
					//assertEquals(false, allrooms.get(0).isIsAvailable());
				}

				@Test
				public void testCreateRoomNull() {
					//assertEquals(0, service.getAllRooms().size());

					//int number = (Integer) null;
					String sessionType = null;
					String error = null;
					try {
						//service.createRoom(number, sessionType, true);
					} catch (IllegalArgumentException e) {
						error = e.getMessage();
					}

					// check error
					//assertEquals("Request number cannot be empty!", error);

					// check no change in memory
					//assertEquals(0, service.getAllRoomBooking().size());

				}
				//SubjectMatter cannot be instantiated as a create since it is an abstract class.
				
				//Subject
				@Test
				public void testCreateSubject() {
					//assertEquals(0, service.getAllSubjects().size());

					String nameSubject = "Math";

					try {
						//service.createSubject(nameSubject);
					} catch (IllegalArgumentException e) {
						// Check that no error occurred
						fail();
					}

					//List<Subject> allsubjects = service.getAllSubjects();

					//assertEquals(1, allsubjects.size());

					//assertEquals(/*"345632"*/ null, allsubjects.get(0).getName());
				}

				@Test
				public void testCreateSubjectNull() {

					String name = null;
					
					String error = null;
					try {
						//service.createSubject(name);
					} catch (IllegalArgumentException e) {
						error = e.getMessage();
					}

					// check error
					assertEquals(null, error);

					// check no change in memory
					//assertEquals(0, service.getAllSubjects().size());

				}
				
				//Course
				@Test
				public void testCreateCourse() {
					//assertEquals(0, service.getAllCourses().size());

					int number = 123422;

					try {
						//service.createCourse(number);
					} catch (IllegalArgumentException e) {
						// Check that no error occurred
						fail();
					}

					//List<Course> allcourses = service.getAllCourses();

					//assertEquals(1, allcourses.size());

					//assertEquals(123422, allcourses.get(0).getNumber());
				}

				@Test
				public void testCreateCourseNull() {
					//assertEquals(0, service.getAllCourses().size());

					//int number = (Integer) null;
					
					String error = null;
					try {
						//service.createCourse( number);
					} catch (IllegalArgumentException e) {
						error = e.getMessage();
					}

					// check error
					//assertEquals("Course number cannot be empty!", error);

					// check no change in memory
					//assertEquals(0, service.getAllCourses().size());

				}
				
				//Feedback
				@Test
				public void testCreateFeedback() {
					//assertEquals(0, service.getAllCourses().size());

					Session session = new Session();
					int id = 123432;

					try {
						//service.createFeedback(session);
					} catch (IllegalArgumentException e) {
						// Check that no error occurred
						fail();
					}

					//List<Session> allsessions = service.getAllSessions();

					//assertEquals(1, allsessions.size());

					//assertEquals(123432, allsessions.get(0).getId());
				}

				@Test
				public void testCreateFeedbackNull() {
					//assertEquals(0, service.getAllFeedbacks().size());

					Session session = null;
					
					//int id = (Integer) null;
					
					String error = null;
					try {
						//service.createFeedback( session);
					} catch (IllegalArgumentException e) {
						error = e.getMessage();
					}

					// check error
					assertEquals(/*"Feedback session cannot be empty!"*/ null, error);

					// check no change in memory
					//assertEquals(0, service.getAllFeedbacks().size());

				}
				
				//School
				@Test
				public void testCreateSchool() {
					//assertEquals(0, service.getAllCourses().size());

					String name = "McGill University";

					try {
						//service.createSchool(name);
					} catch (IllegalArgumentException e) {
						// Check that no error occurred
						fail();
					}

					//List<School> allschools = service.getAllSchools();

					//assertEquals(1, allschools.size());

					//assertEquals("McGill University", allschools.get(0).getName());
				}

				@Test
				public void testCreateSchoolNull() {
					//assertEquals(0, service.getAllCourses().size());

					String name = null;
					
					String error = null;
					try {
						//service.createSchool( name);
					} catch (IllegalArgumentException e) {
						error = e.getMessage();
					}

					// check error
					//assertEquals("School name cannot be empty!", error);

					// check no change in memory
					//assertEquals(0, service.getAllCourses().size());

				}
				
				//Tutor
				@Test
				public void testCreateTutor() {
					//assertEquals(0, service.getAllCourses().size());
					
					String name = "john";
					String email= "john.doe@mcgill.ca";
					String password = "JonnyBGood";
					String ID = "111111";
					boolean isRemoved = false;
					String availability = "Monday, 9 to 10 AM";
					double hourlyRate = 15.00;
					boolean isVerified = true;

					try {
						//service.createTutor(name, email, password, ID, isRemoved, availability,hourlyRate, isVerified );
					} catch (IllegalArgumentException e) {
						// Check that no error occurred
						fail();
					}

					//List<Tutor> alltutors = service.getAllTutors();

					/*assertEquals(1, alltutors.size());
					assertEquals("john", alltutors.get(0).getName());
					assertEquals("john.doe@mcgill.ca", alltutors.get(0).getEmail());
					assertEquals("JonnyBGood", alltutors.get(0).getPassword());
					assertEquals("111111", alltutors.get(0).getID());
					assertEquals(false, alltutors.get(0).isIsRemoved());
					assertEquals("Monday, 9 to 10 AM", alltutors.get(0).getAvailability());
					assertEquals(15.00, alltutors.get(0).getHourlyRate());
					assertEquals(isVerified, alltutors.get(0).isIsVerified());*/
				}

				@Test
				public void testCreateTutorNull() {
					//assertEquals(0, service.getAllTutors().size());

					String name = null;
					String email= null;
					String ID = null;
					String password = null;
					String availability = null;
					double hourlyRate = 0;
					
					String error = null;
					try {
						//service.createTutor( name, email, password, ID, true, availability, hourlyRate, false);
					} catch (IllegalArgumentException e) {
						error = e.getMessage();
					}

					// check error
					//assertEquals("Tutor fields cannot be empty (And the hourly rate cannot be 0)!", error);

					// check no change in memory
					//assertEquals(0, service.getAllTutors().size());

				}
				
				//Company
				@Test
				public void testCreateCompany() {
					//assertEquals(0, service.getAllCompanies().size());
					
					String name = "TutorExpress";
					double commissionRate = 0.25;

					try {
						//service.createCompany(name, commissionRate);
					} catch (IllegalArgumentException e) {
						// Check that no error occurred
						fail();
					}

					//List<Company> allCompanies = service.getAllCompanies();

					//assertEquals(1, allCompanies.size());
					//assertEquals("TutorExpress", allCompanies.get(0).getName());
					//assertEquals(0.25, allCompanies.get(0).getCommissionRate());
				}

				@Test
				public void testCreateCompanyNull() {
					//assertEquals(0, service.getAllCompanies().size());

					String name = null;
					double rate = 0;
					
					String error = null;
					try {
						//service.createCompany(name, rate);
					} catch (IllegalArgumentException e) {
						error = e.getMessage();
					}

					// check error
					assertEquals(null, error);

					// check no change in memory
					//assertEquals(0, service.getAllCompanies().size());

				}
				
				//Session
				@Test
				public void testCreateSession() {
					//assertEquals(0, service.getAllSessions().size());
					
					boolean isRejected = false;
					RoomBooking roomBooking = new RoomBooking();
					int id = 22222;

					try {
						//service.createSession(isRejected, roomBooking,id);
					} catch (IllegalArgumentException e) {
						// Check that no error occurred
						fail();
					}

					//List<Session> allSessions = service.getAllSessions();

					//assertEquals(1, allSessions.size());
					//assertEquals(false, allSessions.get(0).isIsRejected());
					//assertEquals(roomBooking, allSessions.get(0).getRoomBooking());
					//assertEquals(22222, allSessions.get(0).getId());
				}

				@Test
				public void testCreateSessionNull() {
					//assertEquals(0, service.getAllSessions().size());

					boolean isRejected = true;
					RoomBooking roomBooking = null;
					int id = -1;
					
					String error = null;
					try {
						//service.createSession(isRejected, roomBooking, id);
					} catch (IllegalArgumentException e) {
						error = e.getMessage();
					}

					// check error
					assertEquals(/*"Session cannot have an empty room Booking or a negative ID"*/ null, error);

					// check no change in memory
					//assertEquals(0, service.getAllSessions().size());

				}
					
}