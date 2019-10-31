package ca.mcgill.ecse321.eventregistration.model;
import javax.persistence.Id;
import javax.persistence.Entity;

@Entity
public class Session {
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
