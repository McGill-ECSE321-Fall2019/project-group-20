package ca.mcgill.ecse321.projectGroup20.controller;

import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

import ca.mcgill.ecse321.projectGroup20.model.Person;
import ca.mcgill.ecse321.projectGroup20.model.User;
import ca.mcgill.ecse321.projectGroup20.controller.*;
import ca.mcgill.ecse321.projectGroup20.dto.*;
import ca.mcgill.ecse321.projectGroup20.model.*;
import ca.mcgill.ecse321.projectGroup20.dto.Userdto;
import ca.mcgill.ecse321.projectGroup20.service.*;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;



@CrossOrigin(origins = "*")
@RestController
public class projectGroup20RestController {
	
	@Autowired
	projectGroup20Service service = new projectGroup20Service();

	//This is the mapping for the user repository 
	//It sould provide a parameter for the name, email, password and isRemoved for the creation of a user. 
	@PostMapping(value = { "/user", "/user/" })
	public Userdto createCoopPostion(
			@RequestParam(name = "name")  String name,
			@RequestParam(name = "email") String email,
			@RequestParam(name = "password") String password,
			@RequestParam(name = "isRemoved") boolean isRemoved,
	@RequestParam(name = "ID") String ID)
					throws IllegalArgumentException {
		User user = service.getUser(ID);
		if(user == null) {
			throw new IllegalArgumentException("No such student");
		}
		try {
			User newUser = service.createUser(name, email, password, ID,
					isRemoved);
			return convertToDto(newUser);
		}
		catch(Exception e) {
			throw new IllegalArgumentException("Please enter valid information");
		}
	}
	private Userdto convertToDto(User p) {
		if (p == null) {
			throw new IllegalArgumentException("There is no such Person!");
		}
		Userdto personDto = new Userdto(p.getName(), p.getEmail(), p.getPassword(), p.getID(), p.isIsRemoved());
		return personDto;
	}
	
	
	


}