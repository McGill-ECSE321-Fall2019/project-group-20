package ca.mcgill.ecse321.projectGroup20.dto;

public class Companydto {

	private String name;
	private double commissionRate;

	public Companydto() {
	}

	public Companydto(String name,double commissionRate) {
		this.name = name;
		this.commissionRate = commissionRate;
	}

	public String getName() {
		return name;
	}

	public double getCommissionRate() {
		return commissionRate;
	}

}