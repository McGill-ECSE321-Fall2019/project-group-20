package ca.mcgill.ecse321.projectGroup20.dto;

import ca.mcgill.ecse321.projectGroup20.model.User;

public class Userdto {

	private String name;
	private String email;
	private String password;
	private String ID;
	private boolean isRemoved;


	public Userdto() {
	}

	public Userdto(String name,String email, String password, String ID, boolean isRemoved) {
		this.name = name;
		this.email = email;
		this.ID = ID;
		this.password = password;
		this.isRemoved = isRemoved;
	}

	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public String getID() {
		return ID;
	}
	public String getPassword() {
		return password;
	}
	public boolean getisRemoved() {
		return isRemoved;
	}

}