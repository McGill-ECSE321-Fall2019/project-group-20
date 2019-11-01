package ca.mcgill.ecse321.eventregistration.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Person {
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
	private boolean isRemoved;

	public void setIsRemoved(boolean value) {
	    this.isRemoved = value;
	}
	public boolean isIsRemoved() {
	    return this.isRemoved;
	}
}
