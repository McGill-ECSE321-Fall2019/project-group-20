import javax.persistence.Entity;

@Entity
public class Subject extends SubjectMatter{
   private String name;

public void setName(String value) {
    this.name = value;
}
public String getName() {
    return this.name;
}
}
