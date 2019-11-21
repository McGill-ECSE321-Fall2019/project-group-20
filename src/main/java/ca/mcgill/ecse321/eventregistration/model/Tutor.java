package ca.mcgill.ecse321.eventregistration.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Tutor {
	private String name;

	public void setName(String value) {
	    this.name = value;
	}
	@Id
	public String getName() {
	    return this.name;
	}
	private String email;

	public void setEmail(String value) {
	    this.email = value;
	}
	public String getEmail() {
	    return this.email;
	}
	//Subject matter that the Teacher teaches 
	private String subject;

	public void setSubject(String value) {
	    this.subject = value;
	}
	public String getSubject() {
	    return this.subject;
	}
	
	private boolean isRemoved;

	public void setIsRemoved(boolean value) {
	    this.isRemoved = value;
	}
	public boolean isIsRemoved() {
	    return this.isRemoved;
	}
	private String password;

	public void setPassword(String value) {
	    this.password = value;
	}
	public String getPassword() {
	    return this.password;
	}
	private String ID;

	public void setID(String value) {
	    this.ID = value;
	}
	
	public String getID() {
	    return this.ID;
	}
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

