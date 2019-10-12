package ca.mcgill.ecse321.projectGroup20.model;
import javax.persistence.ManyToOne;
import javax.persistence.Id;
import javax.persistence.Entity;

@Entity
public class User{
   private String name;

public void setName(String value) {
    this.name = value;
}
public String getName() {
    return this.name;
}
private String email;

public void setEmail(String value) {
    this.email = value;
}
public String getEmail() {
    return this.email;
}
private String password;

public void setPassword(String value) {
    this.password = value;
}
public String getPassword() {
    return this.password;
}
private String ID;

public void setID(String value) {
    this.ID = value;
}
@Id
public String getID() {
    return this.ID;
}
private boolean isRemoved;

public void setIsRemoved(boolean value) {
    this.isRemoved = value;
}
public boolean isIsRemoved() {
    return this.isRemoved;
}
   private Company company;
   
   @ManyToOne(optional=false)
   public Company getCompany() {
      return this.company;
   }
   
   public void setCompany(Company company) {
      this.company = company;
   }
   
   }
