package ca.mcgill.ecse321.cooperator.controller;


import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ca.mcgill.ecse321.eventregistration.dto.*;
import ca.mcgill.ecse321.eventregistration.model.*;
import ca.mcgill.ecse321.eventregistration.service.*;

@CrossOrigin(origins = "*")
@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping(value = { "/user/", "/user" })
	public UserDto createUser(@PathVariable("user") String name,
		
		@RequestParam(name = "email") String email,
		@RequestParam(name = "password") String password) throws IllegalArgumentException {
		User user = userService.createUser(name, email, password);
		return convertToDto(user);
	}	
	
	private UserDto convertToDto(User p) {
		if (p == null) {
			throw new IllegalArgumentException("There is no such Person!");
		}
		UserDto UserDto = new UserDto(p.getName(),p.getPassword(),p.getEmail());
		return UserDto;
	}
	
	@GetMapping(value = { "/user/{name}", "/user/{name}/" })
	public EventDto getEventByName(@PathVariable("name") String name),
		@RequestParam(name = "email") String email,
		@RequestParam(name = "password") String password) throws IllegalArgumentException {
		return convertToDto(userService.getUser(name));
	}
	
	
