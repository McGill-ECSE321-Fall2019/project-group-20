import java.util.Set;
import java.util.HashSet;

public class Session {
	private boolean isRejected;

	public void setIsRejected(boolean value) {
		this.isRejected = value;
	}

	public boolean isIsRejected() {
		return this.isRejected;
	}

	/**
	* <pre>
	*           1..1     0..2
	* Session ------------------------- Feedback
	*           session        &lt;       feedback
	* </pre>
	*/
	private Set<Feedback> feedback;

	public Set<Feedback> getFeedback() {
		if (this.feedback == null) {
			this.feedback = new HashSet<Feedback>();
		}
		return this.feedback;
	}

	/**
	* <pre>
	*           1..1     0..*
	* Session ------------------------- TutorReview
	*           session        &gt;       tutorReview
	* </pre>
	*/
	private Set<TutorReview> tutorReview;

	public Set<TutorReview> getTutorReview() {
		if (this.tutorReview == null) {
			this.tutorReview = new HashSet<TutorReview>();
		}
		return this.tutorReview;
	}

	/**
	* <pre>
	*           1..1     1..*
	* Session ------------------------- Bill
	*           session        &lt;       bill
	* </pre>
	*/
	private Set<Bill> bill;

	public Set<Bill> getBill() {
		if (this.bill == null) {
			this.bill = new HashSet<Bill>();
		}
		return this.bill;
	}

	/**
	* <pre>
	*           1..1     1..1
	* Session ------------------------- RoomBooking
	*           session        &lt;       roomBooking
	* </pre>
	*/
	private RoomBooking roomBooking;

	public void setRoomBooking(RoomBooking value) {
		this.roomBooking = value;
	}

	public RoomBooking getRoomBooking() {
		return this.roomBooking;
	}

}
