package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	private Integer roomNumb;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Reservation(Integer roomNumb, Date checkIn, Date checkOut) {
		this.roomNumb = roomNumb;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumb() {
		return roomNumb;
	}

	public void setRoomNumb(Integer roomNumb) {
		this.roomNumb = roomNumb;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public long duration() {
		long miliseg = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(miliseg, TimeUnit.MILLISECONDS);

	}
	
	public void updateDates( Date checkIn, Date checkOut) {
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	@Override
	
	public String toString() {
		return "Room number: "
				+ roomNumb
				+ ", check-in: "
				+ sdf.format(checkIn)
				+ ", check-out: "
				+ sdf.format(checkOut)
				+ ", "
				+ duration()
				+ " nights ";
				}

}
