package ca.mcgill.ecse321.eventregistration.dao;

import org.springframework.data.repository.CrudRepository;

import ca.mcgill.ecse321.eventregistration.model.RoomBooking;

public interface RoomBookingRepository extends CrudRepository<RoomBooking, String> {

	RoomBooking findRoomBookingByRequestNb(String requestNb);

}
