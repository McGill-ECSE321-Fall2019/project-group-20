package ca.mcgill.ecse321.projectGroup20.dto;

import ca.mcgill.ecse321.projectGroup20.model.SessionType;

public class Roomdto {

	private int number;
	private SessionType sessionType;
	private boolean isAvailable;

	public Roomdto() {
	}

	public Roomdto(int number,SessionType sessionType, boolean isAvailable) {
		this.number = number;
		this.sessionType = sessionType;
		this.isAvailable = isAvailable;
	}

	public int getNumber() {
		return number;
	}

	public SessionType getSessionType() {
		return sessionType;
	}
	
	public boolean getisAvailable() {
		return isAvailable;
	}

}