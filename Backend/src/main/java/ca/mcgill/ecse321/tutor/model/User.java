package ca.mcgill.ecse321.cooperator.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
	private String name;
	private String password;
	private String email;
	

	public void setName(String value) {
		this.name = value;
	}
	
	public void setPassoword(String value) {
		this.password = value;
	}
	
	public void setEmail(String value) {
		this.email = value;
	}
	
	
	@Id
	public String getName() {
		return this.name;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	
}
