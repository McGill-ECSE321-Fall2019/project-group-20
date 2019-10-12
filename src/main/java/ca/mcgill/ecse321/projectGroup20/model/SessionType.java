package ca.mcgill.ecse321.projectGroup20.model;
import javax.persistence.Entity;

@Entity
public enum SessionType{;
   private String group;

public void setGroup(String value) {
    this.group = value;
}
public String getGroup() {
    return this.group;
}
private String individual;

public void setIndividual(String value) {
    this.individual = value;
}
public String getIndividual() {
    return this.individual;
}
}
