package ca.mcgill.ecse321.eventregistration.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ca.mcgill.ecse321.eventregistration.model.Tutor;

@RepositoryRestResource(collectionResourceRel = "participants", path = "participants")
public interface TutorRepository extends CrudRepository<Tutor, String>{

	Tutor findTutorByName(String name);

}