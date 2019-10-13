package ca.mcgill.ecse321.projectGroup20.service;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
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


@Service
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

	//Users
	@Transactional
	public User createUser(String name, String email, String password, String ID, boolean isRemoved) {
		User person = new User();
		person.setName(name);
		person.setEmail(email);
		person.setPassword(password);
		person.setID(ID);
		person.setIsRemoved(isRemoved);
		userRepository.save(person);
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
		RoomBooking roomBook = new RoomBooking();
		roomBook.setRequestNb(requestNb);
		roomBookingRepository.save(roomBook);
		return roomBook;
	}

	@Transactional
	public RoomBooking getRoomBooking(Session session) {
		RoomBooking roomBooking = tutorReviewRepository.findTutorReviewbySession(session);
		return roomBooking;
	}

	@Transactional
	public List<TutorReview> getAllTutorReviews() {
		return toList(tutorReviewRepository.findAll());
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
	
	@Transactional
	public Tutor createTutor(String availability, double hourlyRate, boolean isVerified) {
		Tutor tutor = new Tutor();
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

	@Transactional
	public Company createCompany(String name, double commissionRate) {
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

	@Transactional
	public Session createSession(boolean isRejected, SubjectMatter subjectMatter, RoomBooking roomBooking, int ID, Set<Feedback> feedback) {
		Session registration = new Session();
		registration.setRoomBooking(roomBooking);

		registration.setSubjectMatter(subjectMatter);
		registration.setIsRejected(isRejected);
		registration.setId(ID);
		registration.setFeedback(feedback);
		sessionRepository.save(registration);
		return registration;
	}

	@Transactional
	public List<Session> getAllSessions(){
		return toList(sessionRepository.findAll());
	}

	@Transactional
	public List<Event> getEventsAttendedByPerson(Person person) {
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