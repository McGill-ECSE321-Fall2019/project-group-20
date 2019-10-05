
public class RoomBooking {
	private String requestNb;

	public void setRequestNb(String value) {
		this.requestNb = value;
	}

	public String getRequestNb() {
		return this.requestNb;
	}

	/**
	* <pre>
	*           1..1     1..1
	* RoomBooking ------------------------- Session
	*           roomBooking        &gt;       session
	* </pre>
	*/
	private Session session;

	public void setSession(Session value) {
		this.session = value;
	}

	public Session getSession() {
		return this.session;
	}

	/**
	* <pre>
	*           1..1     1..1
	* RoomBooking ------------------------- Room
	*           roomBooking        &lt;       room
	* </pre>
	*/
	private Room room;

	public void setRoom(Room value) {
		this.room = value;
	}

	public Room getRoom() {
		return this.room;
	}

}
