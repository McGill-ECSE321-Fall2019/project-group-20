package ca.mcgill.ecse321.projectGroup20.model;
import javax.persistence.ManyToOne;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Bill{
   private double amount;

public void setAmount(double value) {
    this.amount = value;
}

public double getAmount() {
    return this.amount;
}
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
