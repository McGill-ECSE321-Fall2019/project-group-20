
public class TutorReview {
	/**
	* <pre>
	*           0..*     1..1
	* TutorReview ------------------------- Session
	*           tutorReview        &lt;       session
	* </pre>
	*/
	private Session session;

	public void setSession(Session value) {
		this.session = value;
	}

	public Session getSession() {
		return this.session;
	}

}
