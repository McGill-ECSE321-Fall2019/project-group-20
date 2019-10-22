package ca.mcgill.ecse321.projectGroup20.controller;

import java.util.concurrent.atomic.AtomicLong;

import ca.mcgill.ecse321.projectGroup20.model.Person;
import ca.mcgill.ecse321.projectGroup20.dto.PersonDto;
import ca.mcgill.ecse321.projectGroup20.service.*;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;



@CrossOrigin(origins = "*")
@RestController
public class projectGroup20RestController {
	
	@Autowired
	projectGroup20Service service = new projectGroup20Service();
	
	@PostMapping(value = { "/persons/{name}", "/persons/{name}/" })
	public PersonDto createPerson(@PathVariable("name") String name) throws IllegalArgumentException {
		// @formatter:on
		Person person = service.createPerson(name);
		return convertToDto(person);
	}
	
	
	


}