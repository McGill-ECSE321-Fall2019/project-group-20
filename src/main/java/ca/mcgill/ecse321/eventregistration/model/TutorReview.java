package ca.mcgill.ecse321.eventregistration.model;

import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Entity;
import ca.mcgill.ecse321.eventregistration.model.Session;

@Entity
public class TutorReview{
   private Session session;
   
   @Id
   @ManyToOne(optional=false)
   public Session getSession() {
      return this.session;
   }
   
   public void setSession(Session session) {
      this.session = session;
   }
   
   private int rating;

public void setRating(int value) {
    this.rating = value;
}

public int getRating() {
    return this.rating;
}
private String txtReview;

public void setTxtReview(String value) {
    this.txtReview = value;
}
public String getTxtReview() {
    return this.txtReview;
}
}
