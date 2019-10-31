package ca.mcgill.ecse321.eventregistration.dao;

import org.springframework.data.repository.CrudRepository;

import ca.mcgill.ecse321.eventregistration.model.School;

public interface SchoolRepository extends CrudRepository<School, String> {

	School findSchoolByName(String name);

}
