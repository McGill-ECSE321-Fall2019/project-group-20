package ca.mcgill.ecse321.projectGroup20.dao;

import org.springframework.data.repository.CrudRepository;
import ca.mcgill.ecse321.projectGroup20.model.*;

public interface SubjectMatterRepository extends CrudRepository<SubjectMatter, String>{
	
	SubjectMatter findSubjectMatterbyId(int id);

}