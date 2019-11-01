package ca.mcgill.ecse321.eventregistration.dao;

import org.springframework.data.repository.CrudRepository;
import ca.mcgill.ecse321.eventregistration.model.*;

public interface FeedbackRepository extends CrudRepository<Feedback, String>{
	
	Feedback findFeedbackBySession(Session session);

}