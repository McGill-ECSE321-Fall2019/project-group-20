package ca.mcgill.ecse321.projectGroup20.dto;

import ca.mcgill.ecse321.projectGroup20.model.TutorReview;

public class TutorReviewdto {

	private int rating;
	private String txtReview;

	public TutorReviewdto() {
	}

	public TutorReviewdto(int rating,String txtReview) {
		this.rating = rating;
		this.txtReview = txtReview;
	}

	public int getRating() {
		return rating;
	}

	public String gettxtReview() {
		return txtReview;
	}
	

}
