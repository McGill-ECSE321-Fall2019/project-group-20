package ca.mcgill.ecse321.cooperator.dao;

import ca.mcgill.ecse321.cooperator.model.CoopPosition;
import ca.mcgill.ecse321.cooperator.model.Status;
import ca.mcgill.ecse321.cooperator.model.Student;
import ca.mcgill.ecse321.cooperator.model.TermInstructor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CoopPositionRepository extends CrudRepository<CoopPosition, Integer> {
s
    List<CoopPosition> findAvailabilityByDescription(String description);

}