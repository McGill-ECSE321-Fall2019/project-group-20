package ca.mcgill.ecse321.eventregistration.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SessionReview {
	private boolean isRejected;

	public void setIsRejected(boolean value) {
	    this.isRejected = value;
	}
	private int id;

	public void setId(int value) {
		this.id = value;
	}

	@Id
	public int getId() {
		return this.id;
	}

	public boolean isIsRejected() {
	    return this.isRejected;
	}

}
