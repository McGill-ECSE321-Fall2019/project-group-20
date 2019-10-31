package ca.mcgill.ecse321.cooperator.dao;

import ca.mcgill.ecse321.cooperator.model.*;
import ca.mcgill.ecse321.cooperator.service.*;


import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface RateRepository extends CrudRepository<Rate, Integer> {

    List<Rate> getAllRates(String rate);

}

	
	

	
