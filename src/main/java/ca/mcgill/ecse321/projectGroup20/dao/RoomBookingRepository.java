package ca.mcgill.ecse321.projectGroup20.dao;

import org.springframework.data.repository.CrudRepository;
import ca.mcgill.ecse321.projectGroup20.model.*;

public interface RoomBookingRepository extends CrudRepository<User, String>{
	
	RoomBookingRepository findRoomBookingBySession(SessionRepository session);

}