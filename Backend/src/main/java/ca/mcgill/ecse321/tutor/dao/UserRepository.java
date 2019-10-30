package ca.mcgill.ecse321.cooperator.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ca.mcgill.ecse321.eventregistration.model.User;

@RepositoryRestResource(collectionResourceRel = "participants", path = "participants")
public interface UserRepository extends CrudRepository<User, String>{

	User findPersonByName(String name);

}