package ca.mcgill.ecse321.projectGroup20.model;
import javax.persistence.Id;
import javax.persistence.Entity;

@Entity
public class Subject extends SubjectMatter{
   private String name;

public void setName(String value) {
    this.name = value;
}
@Id
public String getName() {
    return this.name;
}
}
