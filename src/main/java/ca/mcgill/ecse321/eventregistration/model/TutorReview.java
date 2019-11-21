package ca.mcgill.ecse321.eventregistration.model;
import javax.persistence.Id;
import javax.persistence.Entity;

@Entity
public class TutorReview {
	private int rating;

	public void setRating(int value) {
	    this.rating = value;
	}

	public int getRating() {
	    return this.rating;
	}
	private String txtReview;

	public void setTxtReview(String value) {
	    this.txtReview = value;
	}
	public String getTxtReview() {
	    return this.txtReview;
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
