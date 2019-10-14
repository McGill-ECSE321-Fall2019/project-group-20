package ca.mcgill.ecse321.projectGroup20.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ca.mcgill.ecse321.projectGroup20.model.User;

/**Test class for the user repository using the CRUD interface
 * and making sure that the data is being sent to the database
 * @author Imane Chafi
 * */

@Repository
public class projectGroup20Repository {

	@Autowired
	EntityManager entityManager;

	@Transactional
	public User createPerson(String name) {
		User p = new User();
		p.setName(name);
		entityManager.persist(p);
		return p;
	}

	@Transactional
	public User getPerson(String name) {
		User p = entityManager.find(User.class, name);
		return p;
	}

	

}