package ca.mcgill.ecse321.eventregistration.model;

import javax.persistence.Id;
import javax.persistence.Entity;

@Entity
public class RoomBooking {
	private String requestNb;

	public void setRequestNb(String value) {
	    this.requestNb = value;
	}
	@Id
	public String getRequestNb() {
	    return this.requestNb;
	}
}
