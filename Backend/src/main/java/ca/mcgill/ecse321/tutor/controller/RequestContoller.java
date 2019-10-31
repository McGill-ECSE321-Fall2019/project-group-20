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

import ca.mcgill.ecse321.cooperator.dto.*;
import ca.mcgill.ecse321.cooperator.model.*;
import ca.mcgill.ecse321.cooperator.service.*;


@CrossOrigin(origins = "*")
@RestController
public class RequestController {
	
	@Autowired
	RequestService requestService;
	@Autowired
	UserService userService;

	@GetMapping(value = { "/reviews/", "/reviews/" })
	public StudentDto getStudent(@RequestParam(name="studentId")int studentId) throws IllegalArgumentException {
		Student s = studentService.getStudentById(studentId);
		return DtoConverters.convertToDto(s);
	}	
	
	@GetMapping(value = { "/sessions/", "/sessions" })
	public List<Session> getAllSessions() {
		List<Sessions> sessions = new ArrayList<>();
		for (Sessions session : RequestService.getAllSessions()) {
			requestDtos.add(session);
		}
		return requestDtos;
	}
	
	@GetMapping(value = { "/sessions/student_id", "/sessions/student_id/" })
	public StudentDto getStudent(@RequestParam(name="studentId")int studentId) throws IllegalArgumentException {
		List<Sessions> sessions = new ArrayList<>();
		for (Sessions studentId : RequestService.getAllSessions()) {
			requestDtos.add(studentId);
		}
		return requestDtos;
	}
}