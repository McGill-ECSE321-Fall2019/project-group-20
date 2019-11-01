package ca.mcgill.ecse321.eventregistration.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Course {
	private int number;

	public void setNumber(int value) {
	    this.number = value;
	}
	@Id
	public int getNumber() {
	    return this.number;
	}
}
