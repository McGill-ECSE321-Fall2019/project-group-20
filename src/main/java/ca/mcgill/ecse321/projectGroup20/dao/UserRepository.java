package ca.mcgill.ecse321.projectGroup20.dao;

import org.springframework.data.repository.CrudRepository;
import ca.mcgill.ecse321.projectGroup20.model.User;

public interface UserRepository extends CrudRepository<User, String>{
	
	User findUserByID(String ID);
}
