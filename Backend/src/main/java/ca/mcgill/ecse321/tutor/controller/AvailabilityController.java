
package ca.mcgill.ecse321.cooperator.controller;

import ca.mcgill.ecse321.cooperator.Utilities;
import ca.mcgill.ecse321.cooperator.dto.CoopPositionDto;
import ca.mcgill.ecse321.cooperator.model.*;
import ca.mcgill.ecse321.cooperator.services.CoopPositionService;
import ca.mcgill.ecse321.cooperator.services.StudentService;
import ca.mcgill.ecse321.cooperator.services.UserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class AvailabilityController {

	@Autowired
	UserEntityService userEntityService;
	
	@Autowired
	AvailiabilityService availabilityService;

	
	/**
	 * Create a new coop position in the database.
	 *
	 * @param startDate   The start date of availability.
	 * @param endDate     The end date of availability.
	 * @param description Textual description of availability.
	 * @return A AvailabilityDto representing the newly added availability.
	 */	
	@PostMapping(value = { "/profile/hours", "/profile/hours/" })
	public Availability addAvailability(
			@RequestParam(name = "startDate") @DateTimeFormat(pattern = "MM/dd/yyyy") Date startDate,
			@RequestParam(name = "endDate") @DateTimeFormat(pattern = "MM/dd/yyyy") Date endDate,
			@RequestParam(name = "description") String description)
			throws IllegalArgumentException {
		try {
			Availability availability = availabilityService.createAvailability(startDate, endDate, description);
			return DtoConverters.convertToDto(availability);
		}
		catch(Exception e) {
			throw new IllegalArgumentException("Please enter valid information");
		}
		
		
	}
}