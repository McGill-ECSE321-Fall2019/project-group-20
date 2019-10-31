
package ca.mcgill.ecse321.cooperator.model;

import javax.persistence.*;
import java.util.*;

@Entity
public class Request {
    
	private Integer studentId;
   
	private String request;
    private String review;
    private List<Reviews> reviews = new List<>();


    public void setCoopId(Integer value) {
        this.coopId = value;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getCoopId() {
        return this.coopId;
    }

    public void setRequest(Status request) {
        this.request = request;
    }
    

    public void getRequest(Status request) {
        return this.request = request;
    }
    
    public void getAllRequest(Status request) {
        return this.requests = requests;
    }

    public Status getReviews() {
        return this.review;
    }
    
    public Status getAllReviews() {
        return this.reviews;
    }
    

}