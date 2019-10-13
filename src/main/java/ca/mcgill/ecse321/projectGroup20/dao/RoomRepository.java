package ca.mcgill.ecse321.projectGroup20.dao;

import org.springframework.data.repository.CrudRepository;
import ca.mcgill.ecse321.projectGroup20.model.*;

public interface RoomRepository extends CrudRepository<Room, String>{
	
	Room findRoomByNumber(int number);

}