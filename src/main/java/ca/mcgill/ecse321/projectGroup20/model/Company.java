package ca.mcgill.ecse321.projectGroup20.model;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Entity;
import java.util.Set;
import java.util.HashSet;

@Entity
public class Company{
   @OneToMany(mappedBy="company")
   public Set<User> getUser() {
      return this.user;
   }
   
   private Set<Feedback> feedback;
   
   @ManyToMany
   public Set<Feedback> getFeedback() {
      return this.feedback;
   }
   
   public void setFeedback(Set<Feedback> feedbacks) {
      this.feedback = feedbacks;
   }
   
   private String name;

public void setName(String value) {
    this.name = value;
}
@Id
public String getName() {
    return this.name;
}
private double commissionRate;

public void setCommissionRate(double value) {
    this.commissionRate = value;
}
public double getCommissionRate() {
    return this.commissionRate;
}
   private Set<User> user;
   
   public void setUser(Set<User> users) {
      this.user = users;
   }
   
   }
