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
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
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

}

