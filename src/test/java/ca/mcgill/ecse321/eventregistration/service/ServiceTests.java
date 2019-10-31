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

import ca.mcgill.ecse321.eventregistration.dao.EventRepository;
import ca.mcgill.ecse321.eventregistration.dao.PersonRepository;
import ca.mcgill.ecse321.eventregistration.dao.RegistrationRepository;
import ca.mcgill.ecse321.eventregistration.model.Event;
import ca.mcgill.ecse321.eventregistration.model.Person;
import ca.mcgill.ecse321.eventregistration.model.Registration;

@RunWith(MockitoJUnitRunner.Silent.class)
public class ServiceTests {

	@Mock
	private PersonRepository personDao;

	@Mock
	private RegistrationRepository registrationDao;

	@Mock
	private EventRepository eventDao;

	@InjectMocks
	private EventRegistrationService service;

	private static final String PERSON_KEY = "TestPerson";
	private static final String NONEXISTING_KEY = "NotAPerson";
	private Person person;
	private Event event;
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
		when(eventDao.save(any(Event.class))).thenAnswer(returnParameterAsAnswer);
		when(registrationDao.save(any(Registration.class))).thenAnswer(returnParameterAsAnswer);
	}

	@Test
	public void testCreatePerson() {
		assertEquals(0, service.getAllPersons().size());

		String name = "Oscar";

		try {
			person = service.createPerson(name);
		} catch (IllegalArgumentException e) {
			// Check that no error occurred
			fail();
		}

		assertEquals(name, person.getName());
	}

	@Test
	public void testCreatePersonNull() {
		String name = null;
		String error = null;

		try {
			person = service.createPerson(name);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}

		// check error
		assertEquals("Person name cannot be empty!", error);
	}

	@Test
	public void testCreatePersonEmpty() {
		String name = "";
		String error = null;

		try {
			person = service.createPerson(name);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}

		// check error
		assertEquals("Person name cannot be empty!", error);
	}

	@Test
	public void testCreatePersonSpaces() {

		String name = " ";
		String error = null;

		try {
			person = service.createPerson(name);
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
		String nameE = "Soccer Game2";
		Calendar c = Calendar.getInstance();
		c.set(2017, Calendar.MARCH, 16, 9, 0, 0);
		Date eventDate = new Date(c.getTimeInMillis());
		Time startTime = new Time(c.getTimeInMillis());
		c.set(2017, Calendar.MARCH, 16, 10, 30, 0);
		Time endTime = new Time(c.getTimeInMillis());
		person = service.createPerson(nameP);
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
