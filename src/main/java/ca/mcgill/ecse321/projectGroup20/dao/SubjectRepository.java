package ca.mcgill.ecse321.projectGroup20.dao;

import org.springframework.data.repository.CrudRepository;
import ca.mcgill.ecse321.projectGroup20.model.*;

public interface SubjectRepository extends CrudRepository<Subject, String>{
	
	Subject findSubjectbyName(String name);

}