package ca.mcgill.ecse321.eventregistration.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Set;
import java.util.HashSet;

@Entity
public class School{
   @OneToMany(mappedBy="school")
   public Set<Course> getCourse() {
      return this.course;
   }
   
   private String name;

public void setName(String value) {
    this.name = value;
}
@Id
public String getName() {
    return this.name;
}
   private Set<Course> course;
   
   public void setCourse(Set<Course> courses) {
      this.course = courses;
   }
}
   
