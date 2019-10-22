package ca.mcgill.ecse321.projectGroup20.dto;

import java.sql.Date;
import java.sql.Time;

public class Billdto {

	private double amount;

	public Billdto() {
	}


	public Billdto(double amount) {
		this();
		this.amount = amount;
	}

	public double getAmount() {
		return amount;
	}

}