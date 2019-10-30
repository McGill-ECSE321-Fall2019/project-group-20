package ca.mcgill.ecse321.cooperator.dto;

import ca.mcgill.ecse321.cooperator.model.Status;

import java.util.Date;
import java.util.List;

public class AvailabilityDto {

    private String description;
    private Date startDate;
    private Date endDate;
    

    // Constructor without term instructor with string
    public AvailabilityDto(String desc, Date start, Date end) {
    	
        this.description = desc;
        this.startDate = start;
        this.endDate = end;s  
    }
 
    public String getDescription() {
        return description;
    }
    public Date getStartDate() {
    	return startDate;
    }

    public Date getEndDate() {
    	return endDate;
    }

  
}
