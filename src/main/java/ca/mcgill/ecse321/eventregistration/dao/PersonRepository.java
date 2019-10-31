package ca.mcgill.ecse321.eventregistration.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ca.mcgill.ecse321.eventregistration.model.Person;

@RepositoryRestResource(collectionResourceRel = "participants", path = "participants")
public interface PersonRepository extends CrudRepository<Person, String>{

	Person findPersonByName(String name);

}
