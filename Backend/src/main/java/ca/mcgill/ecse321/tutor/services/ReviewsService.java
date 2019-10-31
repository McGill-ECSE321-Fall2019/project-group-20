package ca.mcgill.ecse321.cooperator.services;

import ca.mcgill.ecse321.cooperator.Utilities;
import ca.mcgill.ecse321.cooperator.dao.CoopPositionRepository;
import ca.mcgill.ecse321.cooperator.dao.CourseRepository;
import ca.mcgill.ecse321.cooperator.model.CoopPosition;
import ca.mcgill.ecse321.cooperator.model.Course;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.parser.Parser;
import java.util.List;

@Service
public class ReviewsService {
    @Autowired
    CourseRepository courseRepository;
    
    @Autowired
    ReviewsRepository reviewsRepository;

   

   