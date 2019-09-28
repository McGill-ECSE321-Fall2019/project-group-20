
public class User {
	private String name;

	public void setName(String value) {
		this.name = value;
	}

	public String getName() {
		return this.name;
	}

	private String email;

	public void setEmail(String value) {
		this.email = value;
	}

	public String getEmail() {
		return this.email;
	}

	private String password;

	public void setPassword(String value) {
		this.password = value;
	}

	public String getPassword() {
		return this.password;
	}

	private String ID;

	public void setID(String value) {
		this.ID = value;
	}

	public String getID() {
		return this.ID;
	}

	private boolean isRemoved;

	public void setIsRemoved(boolean value) {
		this.isRemoved = value;
	}

	public boolean isIsRemoved() {
		return this.isRemoved;
	}

	/**
	* <pre>
	*           0..*     1..1
	* User ------------------------- Company
	*           user        &gt;       company
	* </pre>
	*/
	private Company company;

	public void setCompany(Company value) {
		this.company = value;
	}

	public Company getCompany() {
		return this.company;
	}

}
