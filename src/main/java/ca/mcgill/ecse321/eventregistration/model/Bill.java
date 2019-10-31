package ca.mcgill.ecse321.eventregistration.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Bill {
	private double amount;

	public void setAmount(double value) {
	    this.amount = value;
	}

	public double getAmount() {
	    return this.amount;
	}
	private String ID;

	public void setID(String value) {
	    this.ID = value;
	}
	
	@Id
	public String getID() {
	    return this.ID;
	}

	
}
