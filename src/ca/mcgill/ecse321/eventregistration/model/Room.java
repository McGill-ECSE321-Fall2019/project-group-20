import javax.persistence.OneToOne;
import javax.persistence.Entity;

@Entity
public class Room{
   private int number;

public void setNumber(int value) {
    this.number = value;
}
public int getNumber() {
    return this.number;
}
private String/*No type specified!*/ sessionType;

public void setSessionType(String/*No type specified!*/ value) {
    this.sessionType = value;
}
public String/*No type specified!*/ getSessionType() {
    return this.sessionType;
}
private boolean isAvailable;

public void setIsAvailable(boolean value) {
    this.isAvailable = value;
}
public boolean isIsAvailable() {
    return this.isAvailable;
}
   private RoomBooking roomBooking;
   
   @OneToOne(mappedBy="room", optional=false)
   public RoomBooking getRoomBooking() {
      return this.roomBooking;
   }
   
   public void setRoomBooking(RoomBooking roomBooking) {
      this.roomBooking = roomBooking;
   }
   
   }
