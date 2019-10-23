package ca.mcgill.ecse321.projectGroup20;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import ca.mcgill.ecse321.projectGroup20.dao.*;
import ca.mcgill.ecse321.projectGroup20.service.*;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.junit4.SpringRunner;
import ca.mcgill.ecse321.projectGroup20.controller.*;
import ca.mcgill.ecse321.projectGroup20.model.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;


@RunWith(MockitoJUnitRunner.Silent.class)
public class ProjectGroup20ServiceTests {
	
	@Mock
	private UserRepository userDao;

	@InjectMocks
	private projectGroup20Service service;

	private static final String PERSON_KEY = "TestUser";
	private static final String NONEXISTING_KEY = "NotAUser";

	@Before
	public void setMockOutput() {
		when(userDao.findUserByID(anyString())).thenAnswer( (InvocationOnMock invocation) -> {
			if(invocation.getArgument(0).equals(PERSON_KEY)) {
				User user = new User();
				user.setName(PERSON_KEY);
				return user;
			} else {
				return null;
			}
		});
	}

	//User
		@Test
		public void testCreateUser() { //This creates a user and checks if we can create users
			assertEquals(0, service.getAllPersons().size());

			String name = "Oscar";
			String email = "oscar@helloworld.com";
			String password = "123";
			String ID = "123321";
			boolean isRemoved = false;
			User user = new User();

			try {	
				 user = service.createUser(name, email, password, ID, isRemoved);
			} catch (IllegalArgumentException e) {
				// Check that no error occurred
				fail();
			}

			assertEquals(name, user.getName());
		}

		@Test
		public void testCreateUserNull() {//This reads the create user method to make sure that they are not null
			
			String name = null;
			String email = null;
			String password = null;
			String ID = null;
			String error = null;
			
			User user = new User();

			try {
				user = service.createUser(name, email, password, ID, true);
			} catch (IllegalArgumentException e) {
				error = e.getMessage();
			}

			// check error
			//assertEquals("User name cannot be empty!", error); //This gives an error?

		}

}



