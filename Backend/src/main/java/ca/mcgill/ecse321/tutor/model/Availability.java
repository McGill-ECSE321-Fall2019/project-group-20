package ca.mcgill.ecse321.cooperator.model;

import javax.persistence.*;
import java.util.*;

@Entity
public class Availability {
   
    private String description;
   
    private Date startDate;
    private Date endDate;
   
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public void setDescription(String value) {
        this.description = value;
    }

    public String getDescription() {
        return this.description;
    }


    public void setStartDate(Date value) {
        this.startDate = value;
    }

    public Date getStartDate() {
        return this.startDate;
    }

    public void setEndDate(Date value) {
        this.endDate = value;
    }

    public Date getEndDate() {
        return this.endDate;
    }

 
}


