package ca.mcgill.ecse321.projectGroup20.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import ca.mcgill.ecse321.projectGroup20.dao.BillRepository;
import ca.mcgill.ecse321.projectGroup20.dao.CompanyRepository;
import ca.mcgill.ecse321.projectGroup20.dao.CourseRepository;
import ca.mcgill.ecse321.projectGroup20.dao.FeedbackRepository;
import ca.mcgill.ecse321.projectGroup20.dao.RoomBookingRepository;
import ca.mcgill.ecse321.projectGroup20.dao.RoomRepository;
import ca.mcgill.ecse321.projectGroup20.dao.SchoolRepository;
import ca.mcgill.ecse321.projectGroup20.dao.SessionRepository;
import ca.mcgill.ecse321.projectGroup20.dao.SubjectMatterRepository;
import ca.mcgill.ecse321.projectGroup20.dao.SubjectRepository;
import ca.mcgill.ecse321.projectGroup20.dao.TutorRepository;
import ca.mcgill.ecse321.projectGroup20.dao.TutorReviewRepository;
import ca.mcgill.ecse321.projectGroup20.dao.UserRepository;
import ca.mcgill.ecse321.projectGroup20.model.*;
import ca.mcgill.ecse321.projectGroup20.dao.PersonRepository;
import ca.mcgill.ecse321.projectGroup20.model.Person;



@Service
@Repository
public class projectGroup20Service {
	@Autowired
	BillRepository billRepository;
	@Autowired
	CompanyRepository companyRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	CourseRepository courseRepository;
	@Autowired
	FeedbackRepository feedbackRepository;
	@Autowired
	RoomRepository roomRepository;
	@Autowired
	RoomBookingRepository roomBookingRepository;
	@Autowired
	SchoolRepository schoolRepository;
	@Autowired
	SessionRepository sessionRepository;
	@Autowired
	SubjectMatterRepository subjectMatterRepository;
	@Autowired
	SubjectRepository subjectRepository;
	@Autowired
	TutorRepository tutorRepository;
	@Autowired
	TutorReviewRepository tutorReviewRepository; 
	@Autowired
	PersonRepository personRepository;

	//Users
	@Transactional
	public User createUser(String name, String email, String password, String ID, boolean isRemoved) {
		if (name == null || name.trim().length() == 0 ) {
	        throw new IllegalArgumentException("Username cannot be null!");
	    }
		if (email == null || email.trim().length() == 0 ) {
	        throw new IllegalArgumentException("User email cannot be null!");
	    }
		if (ID == null || ID.trim().length() == 0 ) {
	        throw new IllegalArgumentException("User ID cannot be null!");
	    }
		User person = new User();
		person.setName(name);
		person.setEmail(email);
		person.setPassword(password);
		person.setID(ID);
		person.setIsRemoved(isRemoved);
		userRepository.save(person);
		return person;
	}
	
	// just for tests with REST
	@Transactional
	public Person createPerson(String name) {
		if (name == null || name.trim().length() == 0) {
			throw new IllegalArgumentException("Person name cannot be empty!");
		}
		Person person = new Person();
		person.setName(name);
		personRepository.save(person);
		return person;
	}	
	
	@Transactional
	public User getUser(String ID) {
		User person = userRepository.findUserByID(ID);
		return person;
	}

	@Transactional
	public List<User> getAllPersons() {
		return toList(userRepository.findAll());
	}
	
	//Bills
	@Transactional
	public Bill createBill(double amount, Session session) {
		if (amount == 0 ) {
	        throw new IllegalArgumentException("Bill cannot be empty!");
	    }
		Bill bill = new Bill();
		bill.setAmount(amount);
		bill.setSession(session);
		billRepository.save(bill);
		return bill;
	}

	@Transactional
	public Bill getBill(Session session) {
		Bill bill = billRepository.findBillBySession(session);
		return bill;
	}

	@Transactional
	public List<Bill> getAllBills() {
		return toList(billRepository.findAll());
	}
	
	//Tutor Review
	@Transactional
	public TutorReview createTutorReview(int rating, String txtReview) {
		//Text review is an optional field, it could be null
		TutorReview tutorRev = new TutorReview();
		tutorRev.setRating(rating);
		tutorRev.setTxtReview(txtReview);
		tutorReviewRepository.save(tutorRev);
		return tutorRev;
	}

	@Transactional
	public TutorReview getTutorReview(Session session) {
		TutorReview tutorReview = tutorReviewRepository.findTutorReviewbySession(session);
		return tutorReview;
	}

	@Transactional
	public List<TutorReview> getAllTutorReviews() {
		return toList(tutorReviewRepository.findAll());
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
	public RoomBooking getRoomBooking(Session session) {
		RoomBooking roomBooking = roomBookingRepository.findRoomBookingBySession(session);
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
	
	//SubjectMatter

	@Transactional
	public SubjectMatter getSubjectMatter(int number) {
		
		SubjectMatter subjectMatter = subjectMatterRepository.findSubjectMatterbyId(number);
		return subjectMatter;
	}

	@Transactional
	public List<SubjectMatter> getAllSubjectMatters() {
		return toList(subjectMatterRepository.findAll());
	}
	
	//Subject
	@Transactional
	public Subject createSubject(String name) {
		if (name == null || name.trim().length() == 0 ) {
	        throw new IllegalArgumentException("Subject name cannot be empty!");
	    }
		Subject subject = new Subject();
		subject.setName(name);
		subjectRepository.save(subject);
		return subject;
	}

	@Transactional
	public Subject getSubject(String name) {
		if (name == null || name.trim().length() == 0 ) {
	        throw new IllegalArgumentException("Subject name cannot be empty!");
	    }
		Subject subject = subjectRepository.findSubjectbyName(name);
		return subject;
	}

	@Transactional
	public List<Subject> getAllSubjects() {
		if (subjectRepository == null ) {
	        throw new IllegalArgumentException("Subject name cannot be empty!");
	        
	    }
		return toList(subjectRepository.findAll());
	}
	
	//Course
	@Transactional
	public Course createCourse(int number) {
		if (number < 0) {
	        throw new IllegalArgumentException("Course number cannot be negative!");
	    }
		Course course = new Course();
		course.setNumber(number);
		subjectMatterRepository.save(course);
		return course;
	}

	@Transactional
	public Course getCourse(int number) {
		if (number < 0) {
	        throw new IllegalArgumentException("Course number cannot be negative!");
	    }
		Course course = courseRepository.findCourseById(number);
		return course;
	}

	@Transactional
	public List<Course> getAllCourses() {
		return toList(courseRepository.findAll());
	}
	
	//School
		@Transactional
		public School createSchool(String name) {
			if (name == null || name.trim().length() == 0 ) {
		        throw new IllegalArgumentException("School name cannot be null!");
		    }
			School school = new School();
			school.setName(name);
			schoolRepository.save(school);
			return school;
		}

		@Transactional
		public School getSchool(String name) {
			if (name == null || name.trim().length() == 0 ) {
		        throw new IllegalArgumentException("School name cannot be null!");
		    }
			School school = schoolRepository.findSchoolByName(name);
			return school;
		}

		@Transactional
		public List<School> getAllSchools() {
			return toList(schoolRepository.findAll());
		}
	
	//Feedback
	
	@Transactional
	public Feedback createFeedback(Session session) {
		Feedback feedback = new Feedback();
		feedback.setSession(session);
		feedbackRepository.save(feedback);
		return feedback;
	}

	@Transactional
	public Feedback getFeedback(Session session) {
		Feedback feedback = feedbackRepository.findFeedbackBySession(session);
		return feedback;
	}

	@Transactional
	public List<Feedback> getAllFeedbacks() {
		return toList(feedbackRepository.findAll());
	}
	
	//Tutor
	@Transactional
	public Tutor createTutor(String name, String email, String password, String ID, boolean isRemoved, String availability, double hourlyRate, boolean isVerified) {
		Tutor tutor = new Tutor();
		tutor.setName(name);
		tutor.setEmail(email);
		tutor.setID(ID);
		tutor.setID(password);
		tutor.setIsRemoved(isRemoved);
		tutor.setAvailability(availability);
		tutor.setHourlyRate(hourlyRate);
		tutor.setIsVerified(isVerified);
		tutorRepository.save(tutor);
		return tutor;
	}

	@Transactional
	public Tutor getTutor(String availability) {
		Tutor tutor = tutorRepository.findTutorbyName(availability);
		return tutor;
	}

	@Transactional
	public List<Tutor> getAllTutors() {
		return toList(tutorRepository.findAll());
	}
	
	//Company
	@Transactional
	public Company createCompany(String name, double commissionRate) {
		if(name == null || name.trim().length() == 0 || commissionRate == 0) {
			throw new IllegalArgumentException("Cannot be null");
		}
		if(companyRepository == null) {
			throw new IllegalArgumentException("Company name cannot be empty (and it needs to make profit)!");
		}
		Company company = new Company();
		company.setName(name);
		company.setCommissionRate(commissionRate);
		companyRepository.save(company);
		return company;
	}

	@Transactional
	public Company getCompany(String name) {
		Company company = companyRepository.findCompanyByName(name);
		return company;
	}

	@Transactional
	public List<Company> getAllCompanies() {
		return toList(companyRepository.findAll());
	}

	//Sessions
	@Transactional
	public Session createSession(boolean isRejected, RoomBooking roomBooking, int ID) {
		Session registration = new Session();
		registration.setRoomBooking(roomBooking);

		registration.getSubjectMatter();
		registration.setIsRejected(isRejected);
		registration.setId(ID);
		registration.getFeedback();
		sessionRepository.save(registration);
		return registration;
	}

	@Transactional
	public List<Session> getAllSessions(){
		return toList(sessionRepository.findAll());
	}


	private <T> List<T> toList(Iterable<T> iterable){
		List<T> resultList = new ArrayList<T>();
		for (T t : iterable) {
			resultList.add(t);
		}
		return resultList;
	}

}