package ca.mcgill.ecse321.eventregistration.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Company {
	
	private String name;

	public void setName(String value) {
	    this.name = value;
	}
	@Id
	public String getName() {
	    return this.name;
	}
	private double commissionRate;

	public void setCommissionRate(double value) {
	    this.commissionRate = value;
	}
	public double getCommissionRate() {
	    return this.commissionRate;
	}

}
