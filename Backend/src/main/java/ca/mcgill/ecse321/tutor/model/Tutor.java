package ca.mcgill.ecse321.cooperator.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Tutor { //This is the tutor class
    private Integer employerID;
    private Set<EmployerContract> employerContract = new HashSet<>();

    public void setEmployerID(Integer value) {
        this.employerID = value;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getEmployerID() {
        return this.employerID;
    }

    @OneToMany(mappedBy = "employer")
    public Set<EmployerContract> getEmployerContract() {
        return this.employerContract;
    }

    public void setEmployerContract(Set<EmployerContract> employerContracts) {
        this.employerContract = employerContracts;
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
    @Override
    public String toString() {
        return "Employer(id= "+getEmployerID()+")";
    }

}
