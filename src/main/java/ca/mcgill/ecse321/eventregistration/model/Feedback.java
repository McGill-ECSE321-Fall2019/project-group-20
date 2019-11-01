package ca.mcgill.ecse321.eventregistration.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Feedback {
	private Session session;
	   
	   @ManyToOne(cascade = { CascadeType.ALL })
	   public Session getSession() {
	      return this.session;
	   }
	   
	   public void setSession(Session session) {
	      this.session = session;
	   }
	   private int id;
	   
	   public void setId(int value) {
	this.id = value;
	    }
	@Id
	public int getId() {
	return this.id;
	    }
	   
}
