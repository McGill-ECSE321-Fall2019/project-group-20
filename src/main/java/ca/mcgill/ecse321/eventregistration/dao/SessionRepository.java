package ca.mcgill.ecse321.eventregistration.dao;

import org.springframework.data.repository.CrudRepository;

import ca.mcgill.ecse321.eventregistration.model.Session;

public interface SessionRepository extends CrudRepository<Session, Integer> {
	
	Session findSessionById(Integer id);
	
}
