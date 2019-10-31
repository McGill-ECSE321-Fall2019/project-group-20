package ca.mcgill.ecse321.eventregistration.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Tutor extends Person {
	private String availability;

	public void setAvailability(String value) {
	    this.availability = value;
	}
	public String getAvailability() {
	    return this.availability;
	}
	private double hourlyRate;

	public void setHourlyRate(double value) {
	    this.hourlyRate = value;
	}
	public double getHourlyRate() {
	    return this.hourlyRate;
	}
	private boolean isVerified;

	public void setIsVerified(boolean value) {
	    this.isVerified = value;
	}
	public boolean isIsVerified() {
	    return this.isVerified;
	}
}

