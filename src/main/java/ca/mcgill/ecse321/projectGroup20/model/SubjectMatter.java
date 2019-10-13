package ca.mcgill.ecse321.projectGroup20.model;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity

public abstract class SubjectMatter{
	@Id	
	private int id;
	public int getId() {
		return this.id;
	}
}

