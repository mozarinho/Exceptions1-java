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

	public String updateDates(Date checkIn, Date checkOut) {

		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now)) {
			return "Error reservation: Reservation dates for update must be future";
		}
		if (!checkOut.after(checkIn)) {
			return "Error in reservation: Check-out date must be after check-in date";
		}

		this.checkIn = checkIn;
		this.checkOut = checkOut;
		return null;
	}

	@Override

	public String toString() {
		return "Room number: " + roomNumb + ", check-in: " + sdf.format(checkIn) + ", check-out: "
				+ sdf.format(checkOut) + ", " + duration() + " nights ";
	}

}
