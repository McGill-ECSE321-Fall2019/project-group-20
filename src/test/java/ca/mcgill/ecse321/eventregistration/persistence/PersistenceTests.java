package ca.mcgill.ecse321.eventregistration.persistence;


import java.sql.Date;
import java.sql.Time;
import java.util.List;

import org.junit.After;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ca.mcgill.ecse321.eventregistration.dao.BillRepository;
import ca.mcgill.ecse321.eventregistration.dao.CourseRepository;
import ca.mcgill.ecse321.eventregistration.dao.EventRegistrationRepository;
import ca.mcgill.ecse321.eventregistration.dao.PersonRepository;
import ca.mcgill.ecse321.eventregistration.dao.RoomRepository;
import ca.mcgill.ecse321.eventregistration.dao.SchoolRepository;
import ca.mcgill.ecse321.eventregistration.dao.TutorRepository;
import ca.mcgill.ecse321.eventregistration.model.Event;
import ca.mcgill.ecse321.eventregistration.service.EventRegistrationService;

@SuppressWarnings("deprecation")
@RunWith(SpringRunner.class)
@SpringBootTest
public class PersistenceTests {

	@Autowired
	private EventRegistrationRepository dao;

	@Autowired
	private EventRegistrationService service;

	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private TutorRepository tutorRepository;
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private RoomRepository roomRepository;
	
	@Autowired
	private BillRepository billRepository;
	
	@Autowired
	private SchoolRepository schoolRepository;

	@After
	public void clearDatabase() {
		personRepository.deleteAll();
		tutorRepository.deleteAll();
		courseRepository.deleteAll();
		roomRepository.deleteAll();
		billRepository.deleteAll();
		schoolRepository.deleteAll();
	}

	@Ignore
	@Test
	public void repositoryTest() {

		dao.createPerson("RepositoryPerson");

	}

	//@Ignore
	@Test
	public void serviceTest( ) {
		service.createPerson("ServicePerson", "ServiceEmail", "ServicePassword", "ServiceID", false);
	}

}
