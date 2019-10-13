package ca.mcgill.ecse321.projectGroup20.model;
import javax.persistence.ManyToOne;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Feedback{
   private Session session;
   
   @Id
   @ManyToOne(optional=false)
   public Session getSession() {
      return this.session;
   }
   
   public void setSession(Session session) {
      this.session = session;
   }
   
   }
