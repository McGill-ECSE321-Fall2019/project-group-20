package ca.mcgill.ecse321.eventregistration.model;

import javax.persistence.Id;
import javax.persistence.Entity;

@Entity
public class Room {

	private int number;

	public void setNumber(int value) {
	    this.number = value;
	}
	@Id
	public int getNumber() {
	    return this.number;
	}
	private String/*No type specified!*/ sessionType;

	public void setSessionType(String/*No type specified!*/ value) {
	    this.sessionType = value;
	}
	public String/*No type specified!*/ getSessionType() {
	    return this.sessionType;
	}
	private boolean isAvailable;

	public void setIsAvailable(boolean value) {
	    this.isAvailable = value;
	}
	public boolean isIsAvailable() {
	    return this.isAvailable;
	}
}
