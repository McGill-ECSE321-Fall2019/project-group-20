package ca.mcgill.ecse321.cooperator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import ca.mcgill.ecse321.eventregistration.dao.UserRepository;
import ca.mcgill.ecse321.eventregistration.model.Person;
import ca.mcgill.ecse321.eventregistration.model.User;

public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	
	@Transactional
	public User createUser(String name, String password, String email) {
		if (name == null || name.trim().length() == 0) {
			throw new IllegalArgumentException("Person name cannot be empty!");
		}
		if (password == null || password.trim().length() == 0) {
			throw new IllegalArgumentException("password name cannot be empty!");
		}
		if (email == null || email.trim().length() == 0) {
			throw new IllegalArgumentException("Email name cannot be empty!");
		}
		
		User user = new User();
		user.setName(name);
		user.setPassoword(password);
		user.setEmail(email);
		userRepository.save(user);
		return user;
	}
	
	@Transactional
	public User getPerson(String name) {
	    if (name == null || name.trim().length() == 0) {
	        throw new IllegalArgumentException("User name cannot be empty!");
	    }
		User user = userRepository.findPersonByName(name);
		return user;
	}


}
