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
public class RateController {
	
	@Autowired
	RateService rateservice;
	
	@Autowired
	UserService userService;


	@PostMapping(value = { "/profile/rate/", "/profile/rate" })
	public UserDto createUser(@PathVariable("user") String name,
		@RequestParam(name = "rate") String rate)
		
		Rate rate = rateService.createRate(name, rate);
		return convertToDto(rate);
	}	
	
	private UserDto convertToDto(Rate p) {
		if (p == null) {
			throw new IllegalArgumentException("There is no such Person!");
		}
		RateDto rateDto = new RateDto(p.getName(),p.getRate());
		return RateDto;
	}
	
	
	@GetMapping(value = { "/company_info/commission_rate/", "/company_info/commission_rate" })
	public List<Rate> getAllRates() {
		List<Rate> personDtos = new ArrayList<>();
		for (Rate rate : RateService.getAllRates()) {
			rateDtos.add(rate);
		}
		return rateDtos;

}