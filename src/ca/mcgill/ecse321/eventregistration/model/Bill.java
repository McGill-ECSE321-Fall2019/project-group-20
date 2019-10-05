
public class Bill {
	private double amount;

	public void setAmount(double value) {
		this.amount = value;
	}

	public double getAmount() {
		return this.amount;
	}

	/**
	* <pre>
	*           1..*     1..1
	* Bill ------------------------- Session
	*           bill        &gt;       session
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
