
public class Course extends SubjectMatter {
	private int number;

	public void setNumber(int value) {
		this.number = value;
	}

	public int getNumber() {
		return this.number;
	}

	/**
	* <pre>
	*           0..*     1..1
	* Course ------------------------- School
	*           course        &gt;       school
	* </pre>
	*/
	private School school;

	public void setSchool(School value) {
		this.school = value;
	}

	public School getSchool() {
		return this.school;
	}

}
