package ca.mcgill.ecse321.projectGroup20.dao;

import org.springframework.data.repository.CrudRepository;
import ca.mcgill.ecse321.projectGroup20.model.*;

public interface BillRepository extends CrudRepository<Bill, String>{
	
	BillRepository findBillBySession(SessionRepository session);
}
