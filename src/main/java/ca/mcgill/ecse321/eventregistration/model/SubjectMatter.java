package ca.mcgill.ecse321.eventregistration.model;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SubjectMatter {

	private int id;
	public void setId(int value) {
		this.id = value;
	}
	@Id	
	public int getId() {
		return this.id;
	}
}
