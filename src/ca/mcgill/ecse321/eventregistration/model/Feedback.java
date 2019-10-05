
public class Feedback {
	/**
	* <pre>
	*           0..2     1..1
	* Feedback ------------------------- Session
	*           feedback        &gt;       session
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
