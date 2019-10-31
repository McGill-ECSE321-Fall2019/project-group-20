package ca.mcgill.ecse321.eventregistration.dao;

import org.springframework.data.repository.CrudRepository;

import ca.mcgill.ecse321.eventregistration.model.Room;

public interface RoomRepository extends CrudRepository<Room, String> {

	Room findRoomByNumber(int number);

}

