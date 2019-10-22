package ca.mcgill.ecse321.projectGroup20.dto;

import ca.mcgill.ecse321.projectGroup20.model.Tutor;

public class Tutordto {

	private String name;
	private String email;
	private String password;
	private String ID;
	private boolean isRemoved;
	private String availability;
	private double hourlyRate;
	private boolean isVerified;

	public Tutordto() {
	}

	public Tutordto(String name,String email, String password, String ID, boolean isRemoved, String availability, double hourlyRate, boolean isVerified) {
		this.name = name;
		this.email = email;
		this.ID = ID;
		this.password = password;
		this.isRemoved = isRemoved;
		this.isVerified = isVerified;
		this.availability = availability;
		this.hourlyRate = hourlyRate;
	}

	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public boolean getisRemoved() {
		return isRemoved;
	}
	public double gethourlyRate() {
		return hourlyRate;
	}

	public String getAvailability() {
		return availability;
	}
	
	public boolean getisVerified() {
		return isVerified;
	}

}