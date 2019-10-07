import javax.persistence.ManyToOne;
import javax.persistence.Id;
import javax.persistence.Entity;

@Entity
public class Course extends SubjectMatter{
   private int number;

public void setNumber(int value) {
    this.number = value;
}
@Id
public int getNumber() {
    return this.number;
}
   private School school;
   
   @ManyToOne(optional=false)
   public School getSchool() {
      return this.school;
   }
   
   public void setSchool(School school) {
      this.school = school;
   }
   
   }
