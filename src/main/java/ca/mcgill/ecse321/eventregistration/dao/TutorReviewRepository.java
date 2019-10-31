package ca.mcgill.ecse321.eventregistration.dao;

import org.springframework.data.repository.CrudRepository;

import ca.mcgill.ecse321.eventregistration.model.TutorReview;

public interface TutorReviewRepository extends CrudRepository<TutorReview, String> {

	TutorReview findTutorReviewById(String ID);

}