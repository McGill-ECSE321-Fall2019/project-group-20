import java.util.Set;
import java.util.HashSet;

public class Company {
	private String name;

	public void setName(String value) {
		this.name = value;
	}

	public String getName() {
		return this.name;
	}

	private double commissionRate;

	public void setCommissionRate(double value) {
		this.commissionRate = value;
	}

	public double getCommissionRate() {
		return this.commissionRate;
	}

	/**
	* <pre>
	*           1..1     0..*
	* Company ------------------------- User
	*           company        &lt;       user
	* </pre>
	*/
	private Set<User> user;

	public Set<User> getUser() {
		if (this.user == null) {
			this.user = new HashSet<User>();
		}
		return this.user;
	}

}
