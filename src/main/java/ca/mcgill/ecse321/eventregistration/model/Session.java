package ca.mcgill.ecse321.eventregistration.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import java.sql.Date;
import java.sql.Time;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Session{
   
   @OneToMany(mappedBy="session")
   public Set<Feedback> getFeedback() {
      return this.feedback;
   }
   
   private Set<TutorReview> tutorReview;
   
   @OneToMany(mappedBy="session" , cascade={CascadeType.ALL})
   public Set<TutorReview> getTutorReview() {
      return this.tutorReview;
   }
   
   public void setTutorReview(Set<TutorReview> tutorReviews) {
      this.tutorReview = tutorReviews;
   }
   
   private SubjectMatter subjectMatter;
   
   @ManyToOne(optional=false)
   public SubjectMatter getSubjectMatter() {
      return this.subjectMatter;
   }
   
   public void setSubjectMatter(SubjectMatter subjectMatter) {
      this.subjectMatter = subjectMatter;
   }
   
   private boolean isRejected;

public void setIsRejected(boolean value) {
    this.isRejected = value;
}
private int id;

public void setId(int value) {
	this.id = value;
}

@Id
public int getId() {
	return this.id;
}

public boolean isIsRejected() {
    return this.isRejected;
}
   private Set<Feedback> feedback;
   
   public void setFeedback(Set<Feedback> feedbacks) {
      this.feedback = feedbacks;
   }
   
   private RoomBooking roomBooking;
   
   @OneToOne(optional=false)
   public RoomBooking getRoomBooking() {
      return this.roomBooking;
   }
   
   public void setRoomBooking(RoomBooking roomBooking) {
      this.roomBooking = roomBooking;
   }
   
   }