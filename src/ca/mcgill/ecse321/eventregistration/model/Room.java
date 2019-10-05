
public class Room {
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

	/**
	* <pre>
	*           1..1     1..1
	* Room ------------------------- RoomBooking
	*           room        &gt;       roomBooking
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
