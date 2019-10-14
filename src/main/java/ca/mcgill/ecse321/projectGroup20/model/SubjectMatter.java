package ca.mcgill.ecse321.projectGroup20.model;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity

public abstract class SubjectMatter{
	
	private int id;
	public void setId(int value) {
		this.id = value;
	}
	@Id	
	public int getId() {
		return this.id;
	}
}

