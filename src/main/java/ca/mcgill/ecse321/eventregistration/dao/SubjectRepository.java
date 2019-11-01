package ca.mcgill.ecse321.eventregistration.dao;

import org.springframework.data.repository.CrudRepository;

import ca.mcgill.ecse321.eventregistration.model.Subject;

public interface SubjectRepository extends CrudRepository<Subject, String> {

	Subject findSubjectById(String ID);

}