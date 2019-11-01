package ca.mcgill.ecse321.eventregistration.model;
import javax.persistence.Id;
import javax.persistence.Entity;

@Entity
public class Subject {

	  private String name;

	  public void setName(String value) {
	      this.name = value;
	  }
	  
	  public String getName() {
	      return this.name;
	  }
	  
	  private int id;

		public void setId(int value) {
			this.id = value;
		}

		@Id
		public int getId() {
			return this.id;
		}
}
