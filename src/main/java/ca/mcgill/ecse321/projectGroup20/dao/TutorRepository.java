package ca.mcgill.ecse321.projectGroup20.dao;

import org.springframework.data.repository.CrudRepository;
import ca.mcgill.ecse321.projectGroup20.model.*;

public interface TutorRepository extends CrudRepository<User, String>{
	
	TutorRepository findTutorbyName(String name); //I don't think we need this interface since Tutor extends User

}