package ca.mcgill.ecse321.projectGroup20.dao;

import org.springframework.data.repository.CrudRepository;

import ca.mcgill.ecse321.projectGroup20.model.Person;

public interface PersonRepository extends CrudRepository<Person, String>{

	Person findPersonByName(String name);

}
