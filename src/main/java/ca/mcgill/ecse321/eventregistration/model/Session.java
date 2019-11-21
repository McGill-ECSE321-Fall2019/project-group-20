package ca.mcgill.ecse321.eventregistration.model;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Session {
	private boolean isRejected;

	public void setIsRejected(boolean value) {
	    this.isRejected = value;
	}
	

	public boolean isIsRejected() {
	    return this.isRejected;
	}
	
	private int id;

	public void setId(int value) {
		this.id = value;
	}

	@Id
	public int getId() {
		return this.id;
	}

		private Person student;
		private Person tutor;

		
		@ManyToOne(optional=false)
		public Person getStudent() {
			return student;
		}
		
		public void setStudent(Person student) {
			this.student = student;
		}
		
		@ManyToOne(optional=false)
		public Person getTutor() {
			return tutor;
		}
		
		public void setTutor(Person tutor) {
			this.tutor = tutor;
		}

	private Date date;

	public void setDate(Date value) {
	this.date = value;
	    }
	public Date getDate() {
	return this.date;
	    }
	private Time startTime;

	public void setStartTime(Time value) {
	this.startTime = value;
	    }
	public Time getStartTime() {
	return this.startTime;
	    }
	private Time endTime;

	public void setEndTime(Time value) {
	this.endTime = value;
	    }
	public Time getEndTime() {
	return this.endTime;
	       }
	}


