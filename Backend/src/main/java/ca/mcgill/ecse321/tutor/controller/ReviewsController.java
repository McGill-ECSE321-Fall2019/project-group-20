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
public class ReviewsController {

	
	@Autowired
	ReviewsService reviewsService;
	
	@PostMapping(value = { "/session/session_id/student_id/", "/session/session_id/student_id" })
	public CoopPositionDto createCoopPostion(
			@RequestParam(name = "rating") String rating,
			@RequestParam(name = "textReview") String review,
			@RequestParam(name = "sessionID") int session_id)
			@RequestParam(name = "studentId") int studentId)
			throws IllegalArgumentException {
		Student student = studentService.getStudentById(studentId);
		if(student == null) {
			throw new IllegalArgumentException("No such student");
		}
		try {
			Reviews review = ReviewsService.createReview(rating, review, id, studentId
			return DtoConverters.convertToDto(review);
		}
		catch(Exception e) {
			throw new IllegalArgumentException("Please enter valid information");
		}
	}
			
			
	@PostMapping(value = { "/session/session_id/tutor_id/", "/session/session_id/tutor_id" })
	public CoopPositionDto createCoopPostion(
			@RequestParam(name = "feedback") String feedback,
			@RequestParam(name = "sessionID") int session_id)
			throws IllegalArgumentException {
		try {
			Reviews review = ReviewsService.createReview(rating, review, id, studentId
			return DtoConverters.convertToDto(review);
		}
		catch(Exception e) {
			throw new IllegalArgumentException("Please enter valid information");
	}
					
}