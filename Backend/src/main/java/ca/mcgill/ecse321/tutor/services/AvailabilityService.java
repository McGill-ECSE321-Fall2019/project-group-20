package ca.mcgill.ecse321.cooperator.services;

import ca.mcgill.ecse321.cooperator.Utilities;
import ca.mcgill.ecse321.cooperator.model.*;
import ca.mcgill.ecse321.cooperator.dao.*;


import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AvailabilityService {
    
    
    @Autowired
    AvailabilityRepository availabilityRepository;
    
  
    /**
     * Create a new coop position in the database.
     *
     * @param startDate   The start date of availability
     * @param endDate     The end date of availability
     * @param description Textual description of availability
     
     * @return An AvailabilityDto representing the newly added availability
     */
    @Transactional
    public CoopPosition createCoopPosition(Date startDate, Date endDate, String description) {
        if (!Utilities.checkNotEmpty(description))
            throw new IllegalArgumentException("Cannot add a coop position with empty description");
        if (startDate == null)
            throw new IllegalArgumentException("Cannot add a coop position with empty startDate");
        if (endDate == null)
            throw new IllegalArgumentException("Cannot add a coop position with empty endDate");
        Availability av = new Availability();
        av.setDescription(description);
       
        av.setStartDate(startDate);
        av.setEndDate(endDate);
        availabilityRepository.save(av);
        return av;
    }

}

